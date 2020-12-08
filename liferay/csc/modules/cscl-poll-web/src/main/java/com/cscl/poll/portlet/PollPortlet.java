package com.cscl.poll.portlet;

import java.io.IOException;
import java.io.InputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.cscl.poll.constants.PollPortletKeys;
import com.cscl.poll.portlet.util.PollUtil;
import com.liferay.document.library.kernel.antivirus.AntivirusScannerException;
import com.liferay.document.library.kernel.exception.DuplicateFileEntryException;
import com.liferay.document.library.kernel.exception.FileExtensionException;
import com.liferay.document.library.kernel.exception.FileNameException;
import com.liferay.document.library.kernel.exception.FileSizeException;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.LiferayFileItemException;
import com.liferay.portal.kernel.upload.UploadException;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.upload.UploadRequestSizeException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.upload.UploadResponseHandler;

/**
 * @author tonmoyt983
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=cscl",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Poll",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/polls/view.jsp",
		"javax.portlet.name=" + PollPortletKeys.POLL,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PollPortlet extends MVCPortlet {
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		super.render(renderRequest, renderResponse);
	}
	
	public void addTempAttachment(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		UploadPortletRequest uploadPortletRequest =
			portal.getUploadPortletRequest(actionRequest);

		checkExceededSizeLimit(actionRequest);

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		String sourceFileName = uploadPortletRequest.getFileName("file");

		try (InputStream inputStream = uploadPortletRequest.getFileAsStream(
				"file")) {

			String mimeType = uploadPortletRequest.getContentType("file");
			long scopeGroupId=PollUtil.getScopeGroupId(PollPortletKeys.POLL_SCOPE, themeDisplay.getScopeGroupId());
			DLAppServiceUtil.addTempFileEntry(scopeGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PollPortletKeys.TEMP_FOLDER_NAME, sourceFileName, inputStream, mimeType);
		}
		catch (Exception e) {
			if (e instanceof AntivirusScannerException ||
				e instanceof DuplicateFileEntryException ||
				e instanceof FileExtensionException ||
				e instanceof FileNameException ||
				e instanceof FileSizeException ||
				e instanceof UploadRequestSizeException) {

				JSONObject jsonObject = uploadResponseHandler.onFailure(
					actionRequest, (PortalException)e);

				writeJSON(actionRequest, actionResponse, jsonObject);
			}
			else {
				throw e;
			}
		}
	}
	
	public void deleteTempAttachment(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);
		String fileName = ParamUtil.getString(actionRequest, "fileName");

		JSONObject jsonObject = jsonFactory.createJSONObject();

		try {
			long scopeGroupId=PollUtil.getScopeGroupId(PollPortletKeys.POLL_SCOPE, themeDisplay.getScopeGroupId());
			DLAppServiceUtil.deleteTempFileEntry(scopeGroupId, DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, PollPortletKeys.TEMP_FOLDER_NAME, fileName);
			jsonObject.put("deleted", Boolean.TRUE);
		}
		catch (Exception e) {
			String errorMessage = themeDisplay.translate(
				"an-unexpected-error-occurred-while-deleting-the-file");

			jsonObject.put(
				"deleted", Boolean.FALSE
			).put(
				"errorMessage", errorMessage
			);
		}

		writeJSON(actionRequest, actionResponse, jsonObject);
	}
	
	protected void checkExceededSizeLimit(PortletRequest portletRequest)
			throws PortalException {

		UploadException uploadException =
			(UploadException)portletRequest.getAttribute(
				WebKeys.UPLOAD_EXCEPTION);

		if (uploadException != null) {
			Throwable cause = uploadException.getCause();

			if (uploadException.isExceededFileSizeLimit()) {
				throw new FileSizeException(cause);
			}

			if (uploadException.isExceededLiferayFileItemSizeLimit()) {
				throw new LiferayFileItemException(cause);
			}

			if (uploadException.isExceededUploadRequestSizeLimit()) {
				throw new UploadRequestSizeException(cause);
			}

			throw new PortalException(cause);
		}
	}
	
	@Reference(unbind = "-")
	protected void setJSONFactory(JSONFactory jsonFactory) {
		this.jsonFactory = jsonFactory;
	}
	
	@Reference(unbind = "-")
	protected void setPortal(Portal portal) {
		this.portal = portal;
	}
	
	@Reference(unbind = "-")
	protected void setUploadResponseHandler(
		UploadResponseHandler uploadResponseHandler) {

		this.uploadResponseHandler = uploadResponseHandler;
	}
	
	protected JSONFactory jsonFactory;
	protected Portal portal;
	protected UploadResponseHandler uploadResponseHandler;
}