package com.cscl.blogs.service.wrapper.hook;


import com.liferay.blogs.service.BlogsEntryLocalServiceWrapper;
import com.liferay.portal.kernel.service.ServiceWrapper;

import org.osgi.service.component.annotations.Component;

/**
 * @author tonmoyt983
 */
@Component(
	immediate = true,
	property = {
	},
	service = ServiceWrapper.class
)
public class CsclBlogsServiceWrapperHook extends BlogsEntryLocalServiceWrapper {

	public CsclBlogsServiceWrapperHook() {
		super(null);
	}

	
	@Override
	public com.liferay.blogs.model.BlogsEntry addEntry(
			long userId, String title, String subtitle, String urlTitle,
			String description, String content, int displayDateMonth,
			int displayDateDay, int displayDateYear, int displayDateHour,
			int displayDateMinute, boolean allowPingbacks,
			boolean allowTrackbacks, String[] trackbacks,
			String coverImageCaption,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				coverImageImageSelector,
			com.liferay.portal.kernel.servlet.taglib.ui.ImageSelector
				smallImageImageSelector,
			com.liferay.portal.kernel.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException {
		System.out.println("HI");
		return super.addEntry(
			userId, title, subtitle, urlTitle, description, content,
			displayDateMonth, displayDateDay, displayDateYear, displayDateHour,
			displayDateMinute, allowPingbacks, allowTrackbacks, trackbacks,
			coverImageCaption, coverImageImageSelector, smallImageImageSelector,
			serviceContext);
	}
}