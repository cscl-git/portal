package com.cscl.poll.portlet.util;

import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionURL;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import com.liferay.blogs.model.BlogsEntry;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.PortalUtil;

public class PollQuestionActionDropdownItemsProvider {
	
	public PollQuestionActionDropdownItemsProvider(BlogsEntry tender, RenderRequest renderRequest,
			RenderResponse renderResponse, PermissionChecker permissionChecker, ResourceBundle resourceBundle) {
		_blog = tender;
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
				add(_getSearchEntryActionUnsafeConsumer());
			}
		};
	}
	
	private UnsafeConsumer<DropdownItem, Exception>
		_getEditEntryActionUnsafeConsumer() {
	
		return dropdownItem -> {
			dropdownItem.setHref(
				_renderResponse.createRenderURL(), "mvcRenderCommandName",
				"/polls/edit_poll_question", Constants.CMD, Constants.UPDATE,
				"redirect", _getRedirectURL(), "entryId",
				_blog.getEntryId());
	
			dropdownItem.setIcon("edit");
			dropdownItem.setLabel(LanguageUtil.get(_resourceBundle, "edit"));
		};
	}
	
	private UnsafeConsumer<DropdownItem, Exception>
	_getDeleteEntryActionUnsafeConsumer() {
	
		ActionURL deleteURL = _renderResponse.createActionURL();
	
		deleteURL.setParameter(ActionRequest.ACTION_NAME, "/polls/edit_poll_question");
		deleteURL.setParameter(Constants.CMD, Constants.DELETE);
		deleteURL.setParameter("redirect", _getRedirectURL());
		deleteURL.setParameter(
			"entryId", String.valueOf(_blog.getEntryId()));
	
		return dropdownItem -> {
			dropdownItem.putData("action", "delete");
			dropdownItem.putData("deleteURL", deleteURL.toString());
			dropdownItem.setLabel(
				LanguageUtil.get(_httpServletRequest, "delete"));
		};
	}
	
	private UnsafeConsumer<DropdownItem, Exception>
	_getSearchEntryActionUnsafeConsumer() {

		return dropdownItem -> {
			dropdownItem.setHref(
				_renderResponse.createRenderURL(), "mvcRenderCommandName",
				"/polls/custom_poll_search", Constants.CMD, Constants.SEARCH,
				"redirect", _getRedirectURL(), "entryId",
				_blog.getEntryId());
	
			dropdownItem.setIcon("details");
			dropdownItem.setLabel(LanguageUtil.get(_resourceBundle, "details"));
		};
	}
	
	private String _getRedirectURL() {
		PortletURL redirectURL = _renderResponse.createRenderURL();

		redirectURL.setParameter("mvcRenderCommandName", "/polls/view");

		return redirectURL.toString();
	}
	
	private final BlogsEntry _blog;
	private final HttpServletRequest _httpServletRequest;
	private final PermissionChecker _permissionChecker;
	private final RenderResponse _renderResponse;
	private final ResourceBundle _resourceBundle;
}