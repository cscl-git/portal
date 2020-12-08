package com.cscl.dashboard.poll.portlet.util;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.petra.string.StringPool;
import com.liferay.polls.model.PollsQuestion;
import com.liferay.polls.model.PollsVote;
import com.liferay.polls.service.PollsVoteLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.resource.ModelResourcePermission;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;

@Component(immediate = true, service = {})
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
	
	public static String getTitle(String title, Locale locale) {
		String val="";
		try{
			//title=HtmlUtil.unescape(title);
			val = LocalizationUtil.getLocalization(title, LocaleUtil.toLanguageId(locale));
		}catch(Exception e){
			
		}
		return val;
	}

	public static String getContent(String content, Locale locale) {
		String val="";
		try{
			//content=HtmlUtil.unescape(content);
			val = LocalizationUtil.getLocalization(content, LocaleUtil.toLanguageId(locale));
			
		}catch(Exception e){
			
		}
		return val;
	}
	
	public static boolean hasVoted(
			HttpServletRequest httpServletRequest, long questionId)
		throws PortalException {

		ThemeDisplay themeDisplay =
			(ThemeDisplay)httpServletRequest.getAttribute(
				WebKeys.THEME_DISPLAY);

		if (themeDisplay.isSignedIn()) {
			PollsVote vote = PollsVoteLocalServiceUtil.fetchQuestionUserVote(
				questionId, themeDisplay.getUserId());

			if (vote == null) {
				return false;
			}

			return true;
		}
		return false;

		/*
		 * String cookie = CookieKeys.getCookie( httpServletRequest,
		 * _getCookieName(questionId));
		 * 
		 * return GetterUtil.getBoolean(cookie);
		 */
	}
	
	private static String _getCookieName(long questionId) {
		return PollsQuestion.class.getName() + StringPool.POUND + questionId;
	}
	
	public static boolean contains(
			PermissionChecker permissionChecker, PollsQuestion question,
			String actionId)
		throws PortalException {

		return _pollsQuestionModelResourcePermission.contains(
			permissionChecker, question, actionId);
	}
	
	@Reference(
		target = "(model.class.name=com.liferay.polls.model.PollsQuestion)",
		unbind = "-"
	)
	protected void setModelResourcePermission(
		ModelResourcePermission<PollsQuestion> modelResourcePermission) {

		_pollsQuestionModelResourcePermission = modelResourcePermission;
	}

	private static ModelResourcePermission<PollsQuestion>
		_pollsQuestionModelResourcePermission;
		
}
