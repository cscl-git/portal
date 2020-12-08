package com.cscl.tender.portlet.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.cscl.tender.constants.TenderPortletKeys;
import com.cscl.tender.model.CsclTender;
import com.cscl.tender.portlet.util.DLFileUtil;
import com.cscl.tender.service.CsclTenderLocalServiceUtil;
import com.liferay.announcements.kernel.exception.EntryDisplayDateException;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.TempFileEntryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
		property = {
			"javax.portlet.name=" + TenderPortletKeys.TENDER,
			"mvc.command.name=/tender/edit_tender"
		},
		service = MVCActionCommand.class
	)
public class EditTenderMVCActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(
				JavaConstants.JAVAX_PORTLET_CONFIG);

			String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

			try {
				if (Validator.isNull(cmd)) {
					return;
				}
				else if (cmd.equals(Constants.ADD) ||
						 cmd.equals(Constants.UPDATE)) {

					updateTender(portletConfig, actionRequest, actionResponse);
				}
				else if (cmd.equals(Constants.DELETE)) {
					deleteTender(actionRequest);
				}

				WindowState windowState = actionRequest.getWindowState();

				if (windowState.equals(LiferayWindowState.POP_UP)) {
					String redirect = portal.escapeRedirect(
						ParamUtil.getString(actionRequest, "redirect"));

					if (Validator.isNotNull(redirect)) {
						actionResponse.sendRedirect(redirect);
					}
				}
				else {
					sendRedirect(actionRequest, actionResponse);
				}
			}
			catch (Exception e) {
				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter(
					"mvcPath", "/tender/edit_tender.jsp");
			}
		
	}
	
	protected void updateTender(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		
		long tenderId = ParamUtil.getLong(actionRequest, "tenderId");
		long tenderCategoryId = ParamUtil.getLong(actionRequest, "tenderCategory");
		int status = ParamUtil.getInteger(actionRequest, "status");
		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "title");
		Map<Locale, String> descriptionMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");
		
		Date publishDate = getPublishDate(actionRequest, user);
		Date lastApplyDate = getLastApplyDate(actionRequest, user);
		Date tenderOpeningDate = getTenderOpeningDate(actionRequest, user);
		
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				CsclTender.class.getName(), actionRequest);
		
		if (tenderId <= 0) {

			// Add Tender

			tenderId = CounterLocalServiceUtil.increment(CsclTender.class.getName());
			CsclTender tender = CsclTenderLocalServiceUtil.createCsclTender(tenderId);
			tender.setTitleMap(titleMap);
			tender.setDescriptionMap(descriptionMap);
			tender.setTenderCategoryId(tenderCategoryId);
			tender.setPublishDate(publishDate);
			tender.setLastApplyDate(lastApplyDate);
			tender.setTenderOpeningDate(tenderOpeningDate);
			tender.setStatus(status);
			tender.setCreateDate(new Date());
			tender.setModifiedDate(new Date());
			tender.setUserName(user.getFullName());
			tender.setCreatedById(user.getUserId());
			tender.setUpdatedById(user.getUserId());
			CsclTenderLocalServiceUtil.addCsclTender(tender);
			
			_log.info("Tender created successfully");
			
			uploadAttachments(actionRequest, actionResponse, themeDisplay, serviceContext, tender);
			
		}else {

			// Update Tender

			CsclTender tender = CsclTenderLocalServiceUtil.getCsclTender(tenderId);
			tender.setTitleMap(titleMap);
			tender.setDescriptionMap(descriptionMap);
			tender.setTenderCategoryId(tenderCategoryId);
			tender.setPublishDate(publishDate);
			tender.setLastApplyDate(lastApplyDate);
			tender.setTenderOpeningDate(tenderOpeningDate);
			tender.setStatus(status);
			tender.setModifiedDate(new Date());
			tender.setUpdatedById(user.getUserId());
			CsclTenderLocalServiceUtil.updateCsclTender(tender);
		}
	}
	
	protected void deleteTender(ActionRequest actionRequest)
		throws Exception {

		long tenderId = ParamUtil.getLong(actionRequest, "tenderId");

		CsclTenderLocalServiceUtil.deleteCsclTender(tenderId);
	}
	
	private void uploadAttachments(ActionRequest actionRequest,
			ActionResponse actionResponse, ThemeDisplay themeDisplay, ServiceContext serviceContext, CsclTender tender) {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String [] selectedFile = uploadRequest.getParameterValues("selectUploadedFile");
		if (ArrayUtil.isEmpty(selectedFile)) {
			return;
		}

		Folder folder = DLFileUtil.getFolder(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), tender.getTenderId(), TenderPortletKeys.TENDER_FOLDER_NAME);
		List<ObjectValuePair<String, InputStream>> inputStreamOVPs = new ArrayList<ObjectValuePair<String, InputStream>>(selectedFile.length);
		InputStream is = null;
		FileEntry tempFileEntry = null;
		String newFileName = null;
		ObjectValuePair<String, InputStream> inputStreamOVP = null;
		Set<String> nameSet = new HashSet<String>();
		
		for (String selectedFileName : selectedFile) {
			try {
				tempFileEntry = TempFileEntryUtil.getTempFileEntry(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), TenderPortletKeys.TEMP_FOLDER_NAME,selectedFileName);
				is = tempFileEntry.getContentStream();
				newFileName = selectedFileName;
				
				if (nameSet.contains(newFileName)) {
					newFileName = DLFileUtil.getNewFileName(nameSet, newFileName);
				}
				nameSet.add(newFileName);
				inputStreamOVP = new ObjectValuePair<String, InputStream>(newFileName, is);
				inputStreamOVPs.add(inputStreamOVP);
				
				if (tempFileEntry != null) {
					TempFileEntryUtil.deleteTempFileEntry(
						tempFileEntry.getFileEntryId());
				}
			}catch(Exception e) {
				_log.error("Error in populate file :"+selectedFileName,e);
			}
		}
		
		try {
			PortletFileRepositoryUtil.addPortletFileEntries(themeDisplay.getScopeGroupId(), themeDisplay.getUserId(), CsclTender.class.getName(), tender.getTenderId(),
					TenderPortletKeys.TENDER, folder.getFolderId(), inputStreamOVPs);
			_log.info("Files uploaded successfully for tender :"+tender.getTenderId());
		}catch(Exception e) {
			_log.error("Error in upload files for tender :"+tender.getTenderId(),e);
		}
	}
	
	private Date getPublishDate(ActionRequest actionRequest, User user) throws PortalException {
		int publishDateMonth = ParamUtil.getInteger(
				actionRequest, "publishDateMonth");
		int publishDateDay = ParamUtil.getInteger(
			actionRequest, "publishDateDay");
		int publishDateYear = ParamUtil.getInteger(
			actionRequest, "publishDateYear");
		int publishDateHour = ParamUtil.getInteger(
			actionRequest, "publishDateHour");
		int publishDateMinute = ParamUtil.getInteger(
			actionRequest, "publishDateMinute");
		int publishDateAmPm = ParamUtil.getInteger(
			actionRequest, "publishDateAmPm");

		if (publishDateAmPm == Calendar.PM) {
			publishDateHour += 12;
		}
		
		return PortalUtil.getDate(publishDateMonth, publishDateDay,
				publishDateYear, publishDateHour, publishDateMinute,
				user.getTimeZone(), EntryDisplayDateException.class);
	}
	
	private Date getLastApplyDate(ActionRequest actionRequest, User user) throws PortalException {
		int lastApplyDateMonth = ParamUtil.getInteger(
				actionRequest, "lastApplyDateMonth");
		int lastApplyDateDay = ParamUtil.getInteger(
			actionRequest, "lastApplyDateDay");
		int lastApplyDateYear = ParamUtil.getInteger(
			actionRequest, "lastApplyDateYear");
		int lastApplyDateHour = ParamUtil.getInteger(
			actionRequest, "lastApplyDateHour");
		int lastApplyDateMinute = ParamUtil.getInteger(
			actionRequest, "lastApplyDateMinute");
		int lastApplyDateAmPm = ParamUtil.getInteger(
			actionRequest, "lastApplyDateAmPm");

		if (lastApplyDateAmPm == Calendar.PM) {
			lastApplyDateHour += 12;
		}
		
		return PortalUtil.getDate(lastApplyDateMonth, lastApplyDateDay,
				lastApplyDateYear, lastApplyDateHour, lastApplyDateMinute,
				user.getTimeZone(), EntryDisplayDateException.class);
	}
	
	private Date getTenderOpeningDate(ActionRequest actionRequest, User user) throws PortalException {
		int tenderOpeningDateMonth = ParamUtil.getInteger(
				actionRequest, "tenderOpeningDateMonth");
		int tenderOpeningDateDay = ParamUtil.getInteger(
			actionRequest, "tenderOpeningDateDay");
		int tenderOpeningDateYear = ParamUtil.getInteger(
			actionRequest, "tenderOpeningDateYear");
		int tenderOpeningDateHour = ParamUtil.getInteger(
			actionRequest, "tenderOpeningDateHour");
		int tenderOpeningDateMinute = ParamUtil.getInteger(
			actionRequest, "tenderOpeningDateMinute");
		int tenderOpeningDateAmPm = ParamUtil.getInteger(
			actionRequest, "tenderOpeningDateAmPm");

		if (tenderOpeningDateAmPm == Calendar.PM) {
			tenderOpeningDateHour += 12;
		}
		
		return PortalUtil.getDate(tenderOpeningDateMonth, tenderOpeningDateDay,
				tenderOpeningDateYear, tenderOpeningDateHour, tenderOpeningDateMinute,
				user.getTimeZone(), EntryDisplayDateException.class);
	}

	@Reference
	protected Portal portal;

	public static Log _log = LogFactoryUtil.getLog(EditTenderMVCActionCommand.class);

}
