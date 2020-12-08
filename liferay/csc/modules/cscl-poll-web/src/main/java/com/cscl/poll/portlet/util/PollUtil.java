package com.cscl.poll.portlet.util;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.liferay.petra.string.StringPool;
import com.liferay.polls.model.PollsQuestion;
import com.liferay.polls.model.PollsVote;
import com.liferay.polls.service.PollsVoteLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

public class PollUtil {

	public static long getScopeGroupId(String entryType, long groupId){
		long scopeGroupId = 0;		
		try{
			long layoutClassNameId = PortalUtil.getClassNameId(Layout.class.getName());						
			Company company = CompanyLocalServiceUtil.getCompanyByMx(PropsUtil.get(PropsKeys.COMPANY_DEFAULT_WEB_ID));
			if(groupId == 0){
				Group defaultGroup = GroupLocalServiceUtil.getGroup(company.getCompanyId(), "Guest");
				groupId = defaultGroup.getGroupId();
			}			
			
			List<Group> groups = GroupLocalServiceUtil.getGroups(company.getCompanyId(), groupId, false);
			for(Group gr : groups){
				if (gr.getClassNameId() == layoutClassNameId) {
					Layout layout = LayoutLocalServiceUtil.getLayout(gr.getClassPK());
					if(layout!=null && layout.getName("en_US").equalsIgnoreCase(entryType)){
						scopeGroupId = gr.getGroupId();
						break;
					}
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return scopeGroupId;
	}
}
