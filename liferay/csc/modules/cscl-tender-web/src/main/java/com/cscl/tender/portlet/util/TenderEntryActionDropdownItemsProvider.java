package com.cscl.tender.portlet.util;

import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionURL;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.cscl.tender.model.CsclTender;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.PortalUtil;

public class TenderEntryActionDropdownItemsProvider {
	
	public TenderEntryActionDropdownItemsProvider(CsclTender tender, RenderRequest renderRequest,
			RenderResponse renderResponse, PermissionChecker permissionChecker, ResourceBundle resourceBundle) {
		_tender = tender;
		_permissionChecker = permissionChecker;
		_renderResponse = renderResponse;
		_resourceBundle = resourceBundle;
		
		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
	}
	
	public List<DropdownItem> getActionDropdownItems() {
		return new DropdownItemList() {
			{
				add(_getEditEntryActionUnsafeConsumer());				
				add(_getDeleteEntryActionUnsafeConsumer());
			}
		};
	}
	
	private UnsafeConsumer<DropdownItem, Exception>
		_getEditEntryActionUnsafeConsumer() {
	
		return dropdownItem -> {
			dropdownItem.setHref(
				_renderResponse.createRenderURL(), "mvcRenderCommandName",
				"/tender/edit_tender", Constants.CMD, Constants.UPDATE,
				"redirect", _getRedirectURL(), "tenderId",
				_tender.getTenderId());
	
			dropdownItem.setIcon("edit");
			dropdownItem.setLabel(LanguageUtil.get(_resourceBundle, "edit"));
		};
	}
	
	private UnsafeConsumer<DropdownItem, Exception>
		_getDeleteEntryActionUnsafeConsumer() {
	
		ActionURL deleteURL = _renderResponse.createActionURL();
	
		deleteURL.setParameter(ActionRequest.ACTION_NAME, "/tender/edit_tender");
		deleteURL.setParameter(Constants.CMD, Constants.DELETE);
		deleteURL.setParameter("redirect", _getRedirectURL());
		deleteURL.setParameter(
			"tenderId", String.valueOf(_tender.getTenderId()));
	
		return dropdownItem -> {
			dropdownItem.putData("action", "delete");
			dropdownItem.putData("deleteURL", deleteURL.toString());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "delete"));
		};
	}
	
	private String _getRedirectURL() {
		PortletURL redirectURL = _renderResponse.createRenderURL();

		redirectURL.setParameter("mvcRenderCommandName", "/tender/view");

		return redirectURL.toString();
	}
	
	private final CsclTender _tender;
	private final HttpServletRequest _httpServletRequest;
	private final PermissionChecker _permissionChecker;
	private final RenderResponse _renderResponse;
	private final ResourceBundle _resourceBundle;
}