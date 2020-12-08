package com.cscl.tender.portlet.action;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.cscl.tender.constants.TenderPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.servlet.SessionErrors;

@Component(
		property = {
			"javax.portlet.name=" + TenderPortletKeys.TENDER,
			"mvc.command.name=/tender/edit_tender"
		},
		service = MVCRenderCommand.class
	)
public class EditTenderMVCRenderCommand implements MVCRenderCommand{
	@Override
	public String render(
			RenderRequest renderRequest, RenderResponse renderResponse)
		throws PortletException {

		try {
			ActionUtil.getTender(renderRequest);
		}
		catch (Exception e) {
			if (e instanceof PrincipalException) {

				SessionErrors.add(renderRequest, e.getClass());

				return "/tender/error.jsp";
			}

			throw new PortletException(e);
		}

		return "/tender/edit_tender.jsp";
	}
}
