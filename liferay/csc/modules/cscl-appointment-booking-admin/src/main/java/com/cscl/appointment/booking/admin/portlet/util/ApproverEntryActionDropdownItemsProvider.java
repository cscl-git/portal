package com.cscl.appointment.booking.admin.portlet.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;

import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import cscl.appointment.booking.model.CsclApproverMapping;

public class ApproverEntryActionDropdownItemsProvider {
	
	public ApproverEntryActionDropdownItemsProvider(CsclApproverMapping appointee, RenderRequest renderRequest,
			RenderResponse renderResponse, PermissionChecker permissionChecker) {
		_appointee = appointee;
		_permissionChecker = permissionChecker;
		_renderResponse = renderResponse;
		
		_httpServletRequest = PortalUtil.getHttpServletRequest(renderRequest);
	}
	
	public List<DropdownItem> getActionDropdownItems() {
		return new DropdownItemList() {
			{
				add(_getEditEntryActionUnsafeConsumer());				
			}
		};
	}
	
	private UnsafeConsumer<DropdownItem, Exception>
	_getEditEntryActionUnsafeConsumer() {

		return dropdownItem -> {
			dropdownItem.setHref(
				_renderResponse.createRenderURL(), "mvcRenderCommandName",
				"/appointmentAdmin/edit_appointment", Constants.CMD, Constants.UPDATE,
				"redirect", _getRedirectURL(), "appointeeId",
				_appointee.getAppointee());
	
			dropdownItem.setIcon("edit");
			dropdownItem.setLabel("Details");
		};
	}

	private String _getRedirectURL() {
		PortletURL redirectURL = _renderResponse.createRenderURL();

		redirectURL.setParameter("mvcRenderCommandName", "/appointmentAdmin/manage_appointee_mapper");

		return redirectURL.toString();
	}
	
	private final CsclApproverMapping _appointee;
	private final HttpServletRequest _httpServletRequest;
	private final PermissionChecker _permissionChecker;
	private final RenderResponse _renderResponse;

}
