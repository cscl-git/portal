package cscl.custom.poll.web.portlet.action;
import com.cscl.polls.model.CsclPollsMaster;
import com.cscl.polls.service.CsclPollsMasterLocalServiceUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.petra.string.StringPool;
import com.liferay.polls.model.PollsVote;
import com.liferay.polls.service.PollsVoteLocalServiceUtil;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
/*import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.JavaConstants;*/
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
/*import javax.portlet.PortletConfig;*/
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import cscl.custom.poll.web.constants.CsclCustomPollWebPortletKeys;

import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;

@Component(
		property = {
			"javax.portlet.name=" + CsclCustomPollWebPortletKeys.CSCLCUSTOMPOLLWEB,
			"mvc.command.name=/customPoll/view"
		},
		service = MVCActionCommand.class
	)


public class AddPollMVCActionCommand extends BaseMVCActionCommand{
	//private CsclPollsMasterService _csclPollsMaster;
	
	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		/*
		 * PortletConfig portletConfig = (PortletConfig)actionRequest.getAttribute(
		 * JavaConstants.JAVAX_PORTLET_CONFIG);
		 */
		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		/*
		 * try {
		 * 
		 * CaptchaUtil.check(actionRequest);
		 */
		boolean isAllowed = false;
		String name = ParamUtil.getString(actionRequest, "name", StringPool.BLANK);
		String email = ParamUtil.getString(actionRequest, "email", StringPool.BLANK);
		String mobile = ParamUtil.getString(actionRequest, "mobile", StringPool.BLANK);
		String age = ParamUtil.getString(actionRequest, "birthDate");
		String sex = ParamUtil.getString(actionRequest, "sex");
		int locality = ParamUtil.getInteger(actionRequest, "locality");
		
		String redirect = ParamUtil.getString(actionRequest, "redirect");
		
		long questionId = ParamUtil.getLong(actionRequest, "questionId");
		long choiceId = ParamUtil.getLong(actionRequest, "choiceId");
		/*if(Validator.isNotNull(name)) {
			if(Validator.isNotNull(email)) {
				if(Validator.isNotNull(mobile)) {*/
					if(Validator.isNotNull(age)) {
						if(Validator.isNotNull(sex)) {
							if(Validator.isNotNull(locality)) {
								isAllowed = true;
							}
						}	
					}	
		/*
		 * } } }
		 */
		
		if(questionId == 0 || choiceId == 0) {
			SessionErrors.add(actionRequest, "question-choice-null");
			actionResponse.setRenderParameter("mvcPath", "/customPoll/view.jsp");
			//return;
		}else {
			if(isAllowed) {
				//add in master table
				Date dateAge = new Date();
				String userName = "";
				try {
					dateAge=new SimpleDateFormat("dd/MM/yyyy").parse(age);//yyyy-MM-dd
					if(Validator.isNotNull(themeDisplay.getUser().getFullName())) {
						userName = themeDisplay.getUser().getFullName();
					}else {
						userName = "Anonymous User";
					}
				}catch(Exception e) {
					dateAge = new Date();
					System.err.println("Error : While converting date");
				}
				long voteId = 0;
				try {
					voteId = CounterLocalServiceUtil.increment(PollsVote.class.getName());
					PollsVote voteObj = PollsVoteLocalServiceUtil.createPollsVote(voteId);
					
					voteObj.setChoiceId(choiceId);
					voteObj.setCreateDate(new Date());
					voteObj.setCompanyId(themeDisplay.getCompanyId());
					voteObj.setGroupId(themeDisplay.getCompanyGroupId());
					voteObj.setQuestionId(questionId);
					voteObj.setUserId(themeDisplay.getUserId());
					voteObj.setUserName(userName);
					voteObj.setVoteDate(new Date());
					voteObj.setModifiedDate(new Date());
					
					PollsVoteLocalServiceUtil.addPollsVote(voteObj);
				}catch(Exception e) {
					System.out.println("Error : While inserting into Polls Vote Table");
				}
				try {
					long id_ = CounterLocalServiceUtil.increment(CsclPollsMaster.class.getName());
					
					//_csclPollsMaster.
					CsclPollsMaster poll = CsclPollsMasterLocalServiceUtil.createCsclPollsMaster(id_);
					poll.setName(name);
					poll.setEmail(email);
					poll.setMobile(mobile);
					
					poll.setBirthDate(dateAge);
					poll.setSex(sex);
					poll.setLocality(locality);
					poll.setQuestionId(questionId);
					poll.setChoiceId(choiceId);
					poll.setVoteId(voteId);
					poll.setCreatedDate(new Date());
					CsclPollsMasterLocalServiceUtil.addCsclPollsMaster(poll);
					
					actionRequest.setAttribute("questionId", questionId);
					actionRequest.setAttribute("redirect", redirect);
					//actionRequest.setAttribute("choiceId", choiceId);
					actionRequest.setAttribute("isFilter", true);
					SessionMessages.add(actionRequest, "success-poll-submit");
					
					/*
					 * PortletURL redirectURL =
					 * PortletURLFactoryUtil.create(PortalUtil.getHttpServletRequest(actionRequest),
					 * portletName,themeDisplay.getLayout().getPlid(), PortletRequest.RENDER_PHASE);
					 * redirectURL.setParameter("jspPage", "/registration.jsp");
					 * actionResponse.sendRedirect(redirectURL.toString());
					 */
					
		            //PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		            //actionResponse.setRenderParameter("jspPage", "/customPoll/poll_display.jsp");
		            actionResponse.getRenderParameters().setValue("mvcPath", "/customPoll/view.jsp");
					//actionResponse.setRenderParameter("jspPage", "/customPoll/poll_display.jsp");
				}catch(Exception e) {
					e.getMessage();
					SessionErrors.add(actionRequest, e.getClass());
					actionResponse.setRenderParameter("mvcPath", "/customPoll/view.jsp");
				}
			}else {
				System.err.println(".......Failed Entry..............");
				SessionErrors.add(actionRequest, "question-choice-null");
				actionResponse.setRenderParameter("mvcPath", "/customPoll/view.jsp");
				return;
			}
		}
	/*}catch(Exception e){
		   if (e instanceof CaptchaTextException || e instanceof CaptchaMaxChallengesException ){
			   System.err.println("text-verification-failed");
		   }
		   SessionErrors.add(actionRequest, "text-verification-failed");
		   actionResponse.setRenderParameter("mvcPath", "/customPoll/view.jsp");
		   return;
	}*/
		
	}

	/*
	 * protected void updatePoll(PortletConfig portletConfig, ActionRequest
	 * actionRequest, ActionResponse actionResponse)throws Exception {
	 * 
	 * 
	 * }
	 */
}
