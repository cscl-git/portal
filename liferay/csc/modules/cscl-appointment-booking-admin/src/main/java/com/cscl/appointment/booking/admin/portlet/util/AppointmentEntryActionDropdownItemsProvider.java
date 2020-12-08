package com.cscl.appointment.booking.admin.portlet.util;

import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItem;
import com.liferay.frontend.taglib.clay.servlet.taglib.util.DropdownItemList;
import com.liferay.petra.function.UnsafeConsumer;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.PortalUtil;

import java.util.List;
import java.util.ResourceBundle;

import javax.portlet.ActionRequest;
import javax.portlet.ActionURL;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;

import cscl.appointment.booking.model.CsclAppointmentMaster;

public class AppointmentEntryActionDropdownItemsProvider {
	
	public AppointmentEntryActionDropdownItemsProvider(CsclAppointmentMaster appointment, RenderRequest renderRequest,
			RenderResponse renderResponse, PermissionChecker permissionChecker) {
		_appointment = appointment;
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
				"redirect", _getRedirectURL(), "appointmentId",
				_appointment.getId_());
	
			dropdownItem.setIcon("edit");
			dropdownItem.setLabel("Details");
		};
	}

	private String _getRedirectURL() {
		PortletURL redirectURL = _renderResponse.createRenderURL();

		redirectURL.setParameter("mvcRenderCommandName", "/appointmentAdmin/tabs_page");

		return redirectURL.toString();
	}
	
	private final CsclAppointmentMaster _appointment;
	private final HttpServletRequest _httpServletRequest;
	private final PermissionChecker _permissionChecker;
	private final RenderResponse _renderResponse;
}
