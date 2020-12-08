package com.cscl.poll.portlet.action;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.WindowState;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.cscl.poll.constants.PollPortletKeys;
import com.cscl.poll.portlet.util.DLFileUtil;
import com.cscl.poll.portlet.util.PollUtil;
import com.cscl.polls.model.CsclPollsMaster;
import com.cscl.polls.service.CsclPollsMasterLocalServiceUtil;
import com.liferay.blogs.model.BlogsEntry;
import com.liferay.blogs.service.BlogsEntryLocalServiceUtil;
import com.liferay.friendly.url.service.FriendlyURLEntryLocalServiceUtil;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.polls.exception.DuplicateVoteException;
import com.liferay.polls.exception.NoSuchChoiceException;
import com.liferay.polls.exception.NoSuchQuestionException;
import com.liferay.polls.exception.QuestionChoiceException;
import com.liferay.polls.exception.QuestionDescriptionException;
import com.liferay.polls.exception.QuestionExpirationDateException;
import com.liferay.polls.exception.QuestionExpiredException;
import com.liferay.polls.exception.QuestionTitleException;
import com.liferay.polls.model.PollsChoice;
import com.liferay.polls.model.PollsQuestion;
import com.liferay.polls.service.PollsQuestionLocalServiceUtil;
import com.liferay.polls.service.PollsQuestionService;
import com.liferay.polls.service.persistence.PollsChoiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.ModelHintsUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.service.ClassNameLocalService;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.FriendlyURLNormalizerUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.TempFileEntryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

@Component(
	property = {
		"javax.portlet.name=" + PollPortletKeys.POLL,
		"mvc.command.name=/polls/edit_poll_question"
	},
	service = MVCActionCommand.class
)
public class EditPollQuestionMVCActionCommand extends BaseMVCActionCommand {
	public static final String CHOICE_DESCRIPTION_PREFIX = "choiceDescription";

	public static final String CHOICE_NAME_PREFIX = "choiceName";

	protected void addAndStoreSelection(
			PortletRequest portletRequest, PollsQuestion question)
		throws Exception {

		String referringPortletResource = ParamUtil.getString(
			portletRequest, "referringPortletResource");

		if (Validator.isNull(referringPortletResource)) {
			return;
		}

		ThemeDisplay themeDisplay = (ThemeDisplay)portletRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		PortletPreferences portletPreferences =
			PortletPreferencesFactoryUtil.getStrictPortletSetup(
				themeDisplay.getLayout(), themeDisplay.getPpid());

		portletPreferences.setValue(
			"entryId", String.valueOf(question.getQuestionId()));

		portletPreferences.store();

		SessionMessages.add(
			portletRequest,
			portal.getPortletId(portletRequest) +
				SessionMessages.KEY_SUFFIX_REFRESH_PORTLET,
			referringPortletResource);
	}

	protected void deleteQuestion(ActionRequest actionRequest)
		throws Exception {

		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		BlogsEntry blogsEntry = BlogsEntryLocalServiceUtil.getBlogsEntry(entryId);
		String pollId = blogsEntry.getExpandoBridge().getAttribute("POLL_ID").toString();
		if(Validator.isNotNull(pollId)){
			BlogsEntry blog = BlogsEntryLocalServiceUtil.getBlogsEntry(entryId);
			BlogsEntryLocalServiceUtil.deleteBlogsEntry(entryId);
			PollsQuestionLocalServiceUtil.deleteQuestion(Long.parseLong(pollId));
			try {
				PortletFileRepositoryUtil.deletePortletFileEntries(blog.getGroupId(), entryId);
			}catch(Exception e) {
				_log.error("Error in deleteQuestion ",e);
			}
			//delete user details
			try {
				List<CsclPollsMaster> details = CsclPollsMasterLocalServiceUtil.getPollsByQuestionId(Long.parseLong(pollId));
				for(CsclPollsMaster master : details) {
					CsclPollsMasterLocalServiceUtil.deleteCsclPollsMaster(master);
				}
			}catch(Exception e) {
				_log.error("Unable to delete user basic details ",e);
			}
		}
	}

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(
			JavaConstants.JAVAX_PORTLET_CONFIG);

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		try {
			if (Validator.isNull(cmd)) {
				return;
			}
			else if (cmd.equals(Constants.ADD) ||
					 cmd.equals(Constants.UPDATE) ||
					 cmd.equals(Constants.VOTE)) {

				updateQuestion(portletConfig, actionRequest, actionResponse);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteQuestion(actionRequest);
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
			_log.error("Error in create/update poll",e);
			if (e instanceof NoSuchQuestionException ||
				e instanceof PrincipalException) {

				SessionErrors.add(actionRequest, e.getClass());

				actionResponse.setRenderParameter(
					"mvcPath", "/polls/edit_poll_question.jsp");
			}
			else if (e instanceof DuplicateVoteException ||
					 e instanceof NoSuchChoiceException ||
					 e instanceof QuestionChoiceException ||
					 e instanceof QuestionDescriptionException ||
					 e instanceof QuestionExpirationDateException ||
					 e instanceof QuestionTitleException) {

				SessionErrors.add(actionRequest, e.getClass());

				hideDefaultErrorMessage(actionRequest);
			}
			else if (e instanceof QuestionExpiredException) {
			}
			else {
				throw e;
			}
		}
	}

	@Reference(unbind = "-")
	protected void setPollsQuestionService(
		PollsQuestionService pollsQuestionService) {

		_pollsQuestionService = pollsQuestionService;
	}

	protected void updateQuestion(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse)
		throws Exception {

		long entryId = ParamUtil.getLong(actionRequest, "entryId");
		long questionId = ParamUtil.getLong(actionRequest, "questionId");

		Map<Locale, String> titleMap = LocalizationUtil.getLocalizationMap(
			actionRequest, "title");
		Map<Locale, String> questionMap =
				LocalizationUtil.getLocalizationMap(actionRequest, "question");
		Map<Locale, String> descMap =
			LocalizationUtil.getLocalizationMap(actionRequest, "description");

		int expirationDateMonth = ParamUtil.getInteger(
			actionRequest, "expirationDateMonth");
		int expirationDateDay = ParamUtil.getInteger(
			actionRequest, "expirationDateDay");
		int expirationDateYear = ParamUtil.getInteger(
			actionRequest, "expirationDateYear");
		int expirationDateHour = ParamUtil.getInteger(
			actionRequest, "expirationDateHour");
		int expirationDateMinute = ParamUtil.getInteger(
			actionRequest, "expirationDateMinute");
		int expirationDateAmPm = ParamUtil.getInteger(
			actionRequest, "expirationDateAmPm");
		boolean neverExpire = ParamUtil.getBoolean(
			actionRequest, "neverExpire");

		if (expirationDateAmPm == Calendar.PM) {
			expirationDateHour += 12;
		}

		List<PollsChoice> choices = new ArrayList<>();

		Set<String> readParameters = new HashSet<>();

		Enumeration<String> enu = actionRequest.getParameterNames();

		while (enu.hasMoreElements()) {
			String param = enu.nextElement();

			if (param.startsWith(CHOICE_DESCRIPTION_PREFIX)) {
				int endIndex = param.indexOf(CharPool.UNDERLINE);

				if (endIndex < 0) {
					endIndex = param.length();
				}

				String id = param.substring(
					CHOICE_DESCRIPTION_PREFIX.length(), endIndex);

				if (readParameters.contains(id)) {
					continue;
				}

				String choiceName = ParamUtil.getString(
					actionRequest, CHOICE_NAME_PREFIX + id);

				Map<Locale, String> localeChoiceDescriptionMap =
					LocalizationUtil.getLocalizationMap(
						actionRequest, CHOICE_DESCRIPTION_PREFIX + id);

				PollsChoice choice = PollsChoiceUtil.create(0);

				choice.setName(choiceName);
				choice.setDescriptionMap(localeChoiceDescriptionMap);

				choices.add(choice);

				readParameters.add(id);
			}
		}

		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			PollsQuestion.class.getName(), actionRequest);
		
		
		/*
		 * String[] guestPermissions= {ActionKeys.VIEW}; String[]
		 * groupPermissions={ActionKeys.ADD_VOTE,ActionKeys.VIEW};
		 * serviceContext.setGuestPermissions(guestPermissions);
		 * serviceContext.setGroupPermissions(groupPermissions);
		 */
		 
		serviceContext.setAddGuestPermissions(true);
		serviceContext.setAddGroupPermissions(true);

		if (entryId <= 0) {

			// Add question

			PollsQuestion question = _pollsQuestionService.addQuestion(
				titleMap, questionMap, expirationDateMonth,
				expirationDateDay, expirationDateYear, expirationDateHour,
				expirationDateMinute, neverExpire, choices, serviceContext);

			// Poll display

			addAndStoreSelection(actionRequest, question);
			
			_log.info("Poll question created successfully");
			
			//Entry to blog
			
			addBlog(portletConfig, actionRequest, actionResponse, question, titleMap, descMap, serviceContext);
		}
		else {

			// Update question

			_pollsQuestionService.updateQuestion(
					questionId, titleMap, questionMap, expirationDateMonth,
				expirationDateDay, expirationDateYear, expirationDateHour,
				expirationDateMinute, neverExpire, choices, serviceContext);
			
			updateBlog(portletConfig, actionRequest, actionResponse, titleMap, descMap, entryId, serviceContext);
			
		}
	}	
	
	private void addBlog(
			PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse, PollsQuestion question, Map<Locale, String> titleMap, Map<Locale, String> descMap, ServiceContext serviceContext)
		throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		String title = LocalizationUtil.updateLocalization(titleMap, "", "Title",LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault()));
		title = LocalizationUtil.getLocalization(title, LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault()));
		String content = LocalizationUtil.updateLocalization(descMap, "", "Content",LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault()));
		long scopeGroupId=PollUtil.getScopeGroupId(PollPortletKeys.POLL_SCOPE, themeDisplay.getScopeGroupId());
		serviceContext.setScopeGroupId(scopeGroupId);
		serviceContext.setAttribute(PollPortletKeys.BLOG_TYPE_ATTRIBUTE, PollPortletKeys.BLOG_TYPE_POLL);
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(question.getCreateDate());
		int displayDateMonth = cal.get(Calendar.MONTH);
		int displayDateDay = cal.get(Calendar.DAY_OF_MONTH);
		int displayDateYear = cal.get(Calendar.YEAR);
		int displayDateHour = cal.get(Calendar.HOUR_OF_DAY);
		int displayDateMinute = cal.get(Calendar.MINUTE);
		boolean allowPingbacks = true;
		boolean allowTrackbacks = true;
		String[] trackbacks = null;
		String coverImageCaption=null;
		ImageSelector coverImageImageSelector = null;
		ImageSelector smallImageImageSelector = null;
		String urltitle= _getUniqueUrlTitle(null,scopeGroupId,getTitle(title));
		//BlogsEntry entry = BlogsEntryLocalServiceUtil.addEntry(themeDisplay.getUserId(),title , content, serviceContext);
		
		BlogsEntry entry = BlogsEntryLocalServiceUtil.addEntry(themeDisplay.getUserId(), title,
										StringPool.BLANK, urltitle, StringPool.BLANK, content,
										displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
										displayDateMinute, allowPingbacks, allowTrackbacks, trackbacks,
										coverImageCaption, coverImageImageSelector, smallImageImageSelector,
										serviceContext);
		 
		
		entry.getExpandoBridge().setAttribute(PollPortletKeys.BLOG_EXPANDO_ATTRIBUTE_POLL, String.valueOf(question.getQuestionId()), true);
		//entry.setUrlTitle(_getUniqueUrlTitle(entry, getTitle(entry.getTitle())));
		entry = BlogsEntryLocalServiceUtil.updateBlogsEntry(entry);
		
		_log.info("Blog created successfully for poll(blog) : "+entry.getEntryId());
		
		uploadAttachments(portletConfig, actionRequest, actionResponse, themeDisplay, serviceContext, entry);
	}
	
	private void updateBlog(
			PortletConfig portletConfig, ActionRequest actionRequest,ActionResponse actionResponse, 
			Map<Locale, String> titleMap, Map<Locale, String> descMap, long entryId, ServiceContext serviceContext)
		throws Exception {
		
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
				WebKeys.THEME_DISPLAY);
		String title = LocalizationUtil.updateLocalization(titleMap, "", "Title",LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault()));
		title = LocalizationUtil.getLocalization(title, LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault()));
		String content = LocalizationUtil.updateLocalization(descMap, "", "Content",LocaleUtil.toLanguageId(LocaleUtil.getSiteDefault()));
		
		BlogsEntry entry = BlogsEntryLocalServiceUtil.updateEntry(themeDisplay.getUserId(), entryId, title, content, serviceContext);
		
		uploadAttachments(portletConfig, actionRequest, actionResponse, themeDisplay, serviceContext, entry);
		
		deleteFile(actionRequest);
	}
	
	private void uploadAttachments(PortletConfig portletConfig, ActionRequest actionRequest,
			ActionResponse actionResponse, ThemeDisplay themeDisplay, ServiceContext serviceContext, BlogsEntry entry) {
		
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String [] selectedFile = uploadRequest.getParameterValues("selectUploadedFile");
		if (ArrayUtil.isEmpty(selectedFile)) {
			return;
		}

		Folder blogFolder = DLFileUtil.getBlogFolder(entry.getGroupId(), themeDisplay.getUserId(), entry.getEntryId(), PollPortletKeys.BLOG_FOLDER_NAME);
		List<ObjectValuePair<String, InputStream>> inputStreamOVPs = new ArrayList<ObjectValuePair<String, InputStream>>(selectedFile.length);
		InputStream is = null;
		FileEntry tempFileEntry = null;
		String newFileName = null;
		ObjectValuePair<String, InputStream> inputStreamOVP = null;
		Set<String> nameSet = new HashSet<String>();
		
		for (String selectedFileName : selectedFile) {
			try {
				tempFileEntry = TempFileEntryUtil.getTempFileEntry(entry.getGroupId(), entry.getUserId(), PollPortletKeys.TEMP_FOLDER_NAME,selectedFileName);
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
			PortletFileRepositoryUtil.addPortletFileEntries(entry.getGroupId(), entry.getUserId(), BlogsEntry.class.getName(), entry.getEntryId(),
					PollPortletKeys.POLL, blogFolder.getFolderId(), inputStreamOVPs);
			_log.info("Files uploaded successfully for poll(blog) ::"+entry.getEntryId());
		}catch(Exception e) {
			_log.error("Error in upload files for poll(blog) :"+entry.getEntryId(),e);
		}
	}
	
	private void deleteFile(ActionRequest actionRequest) throws PortalException {
		UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String [] removeFileEntryIds = uploadRequest.getParameterValues("removeFileEntryIds");
		if (ArrayUtil.isEmpty(removeFileEntryIds)) {
			return;
		}
		for (String fileEntryId : removeFileEntryIds) {
			try {
				if(Validator.isNotNull(fileEntryId)) {
					PortletFileRepositoryUtil.deletePortletFileEntry(Long.parseLong(fileEntryId));
				}
			}catch(Exception e) {
				_log.error("Error in deleted files for poll(blog) :"+fileEntryId,e);
			}
		}
	}
	
	private String _getUniqueUrlTitle(BlogsEntry entry, long groupId, String newTitle) {
		long entryId = (null !=entry ?entry.getEntryId():0);

		String urlTitle = null;

		if (newTitle == null) {
			urlTitle = String.valueOf(entryId);
		}
		else {
			urlTitle = StringUtil.toLowerCase(newTitle.trim());

			if (Validator.isNull(urlTitle) || Validator.isNumber(urlTitle) ||
				urlTitle.equals("rss")) {

				urlTitle = String.valueOf(entryId);
			}
			else {
				urlTitle =
					FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
						urlTitle);
			}

			urlTitle = ModelHintsUtil.trimString(
				BlogsEntry.class.getName(), "urlTitle", urlTitle);
		}

		long classNameId = _classNameLocalService.getClassNameId(
			BlogsEntry.class);

		return FriendlyURLEntryLocalServiceUtil.getUniqueUrlTitle(
				groupId, classNameId, entryId, urlTitle);
	}
	
	private String _getUniqueUrlTitle(String newTitle) {

		String urlTitle = null;

		urlTitle = StringUtil.toLowerCase(newTitle.trim());

		urlTitle =
				FriendlyURLNormalizerUtil.normalizeWithPeriodsAndSlashes(
					urlTitle);

		urlTitle = ModelHintsUtil.trimString(
			BlogsEntry.class.getName(), "urlTitle", urlTitle);

		return urlTitle;
	}
	
	private String getTitle(String title) {
		String val="";
		try{
			val = LocalizationUtil.getLocalization(title, LocaleUtil.toLanguageId(LocaleUtil.getDefault()));
		}catch(Exception e){
			
		}
		return val;
	}

	@Reference
	protected Portal portal;

	private PollsQuestionService _pollsQuestionService;
	
	@Reference
	private ClassNameLocalService _classNameLocalService;
	
	public static Log _log = LogFactoryUtil.getLog(EditPollQuestionMVCActionCommand.class);
}
