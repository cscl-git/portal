<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.petra.string.CharPool"%>
<%@page import="com.liferay.polls.model.PollsChoice"%>
<%@page import="com.liferay.polls.service.PollsQuestionLocalServiceUtil"%>
<%@page import="com.liferay.polls.model.PollsQuestion"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryPos"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.blogs.service.BlogsEntryServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cscl.dashboard.poll.constants.DashboardPollPortletKeys"%>
<%@page import="com.cscl.dashboard.poll.portlet.util.PollUtil"%>
<%@page import="com.liferay.blogs.service.BlogsEntryLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.blogs.model.BlogsEntry"%>
<%@ include file="init.jsp" %>

<%
long pollScopeGroupId=PollUtil.getScopeGroupId(DashboardPollPortletKeys.POLL_SCOPE, themeDisplay.getScopeGroupId());
List<BlogsEntry> tempBlogList = BlogsEntryServiceUtil.getGroupEntries(pollScopeGroupId, WorkflowConstants.STATUS_APPROVED, QueryUtil.ALL_POS,QueryUtil.ALL_POS);
List<BlogsEntry> blogList = new ArrayList<BlogsEntry>();

for(BlogsEntry blog : tempBlogList){
	
	String pollId = blog.getExpandoBridge().getAttribute("POLL_ID").toString();
	if(Validator.isNotNull(pollId)){

		try {
			PollsQuestion question = PollsQuestionLocalServiceUtil.getPollsQuestion(Long.parseLong(pollId));
			if(null != question && !question.isExpired()){
				blogList.add(blog);
			}
		}
		catch (Exception e) {
			System.out.println("Error in fecting poll with poll id "+pollId);
		}
	}
}

String site_url = themeDisplay.getPortalURL();
site_url += "/web/guest/poll";
/* System.out.println("...............................");
try{
	System.out.println("..............................."+permissionChecker.isOmniadmin());
}catch(Exception e1){
	e1.getMessage();
} */

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
int counter=0 ;
String activeCssClass="active";
String pollDisplayUrl="";
long layoutClassNameId = ClassNameLocalServiceUtil.getClassNameId(Layout.class.getName());
Group group = null;
Layout blogLayout = null;
boolean isAllowedToCreatePoll = false;
if(permissionChecker.isOmniadmin()){
	isAllowedToCreatePoll = true;
}else{
	Role role = themeDisplay.getUser().getRoles().stream().filter(userRole -> "Portal Admin".equals(userRole.getName()))
	  .findAny()
	  .orElse(null);
	if(null != role){
		isAllowedToCreatePoll = true;
	}
}
%>

<div id="news-letter" class="text-center parallax-section public-responsive poll-dashboard">
	<div class="parallax-content">
		<div class="container">
			<div class="col-md-12">
				<div class="our-tea text-left">
					<h2 class="text-center heading"><liferay-ui:message key="polls" />
						<%if(isAllowedToCreatePoll){ %>
							<a href="<%=site_url %>" style="float: right;color: #fff;text-decoration: underline;">List of Polls</a>
						<%} %>
					</h2>
					<div>
						<div class="row">
							<div id="news-letterPb" class="text-center parallax-section">
								<div class="parallax-content">
									<div class="container">
										<div class="col-md-12">
											<div id="team-carouselpb" class="carousel slide" data-ride="carousel">
												<a class="team-carousel-left service" href="#team-carouselpb" data-slide="prev" style="margin-top:10%;"><i class="fa fa- fa-chevron-left"></i></a>
												<a class="team-carousel-right service" href="#team-carouselpb" data-slide="next" style="margin-top:10%;"><i class="fa fa- fa-chevron-right"></i></a>
												<div class="carousel-inner">
												
												<%
												if(null != blogList && !blogList.isEmpty()){
													for(BlogsEntry blog : blogList){
														if(counter != 0){
															activeCssClass="";
														}
														
														group = GroupLocalServiceUtil.getGroup(blog.getGroupId());
														if (group.getClassNameId() == layoutClassNameId) {
															blogLayout = LayoutLocalServiceUtil.getLayout(group.getClassPK());
															Group site = GroupLocalServiceUtil.getGroup(blogLayout.getGroupId());
															pollDisplayUrl = site.getPathFriendlyURL(false, themeDisplay) + site.getFriendlyURL() + blogLayout.getFriendlyURL() + "/-/blogs/"
																	+ blog.getUrlTitle();
														}
														
														if(counter%4 == 0){
												%>
															<div class="item carousel-item <%=activeCssClass%>">
																<div class="row">
													<%	} %>
													
													<%
														String pollId = blog.getExpandoBridge().getAttribute("POLL_ID").toString();
														PollsQuestion question = PollsQuestionLocalServiceUtil.getPollsQuestion(Long.parseLong(pollId));
														List<PollsChoice> choices = question.getChoices();
	
														boolean hasVoted = PollUtil.hasVoted(request, question.getQuestionId());
														String pollQuestion=StringUtil.replace(question.getDescription(locale), CharPool.NEW_LINE, "<br />");
														pollQuestion = StringUtil.shorten(HtmlUtil.render(pollQuestion),100);
														String description = StringUtil.shorten(HtmlUtil.render(PollUtil.getContent(blog.getContent(), locale)),75);
													%>
													
													
																	<div class="col-md-6 col-lg-3">
																		<div class="team-member">
																			<div class="single-blog">
																				<div class="clearfix"></div>
																				<div class="entry-content" style="width:100%">
																					<a href="<%=pollDisplayUrl%>">
																						<h2 class="poll-ques"><b><%=pollQuestion %></b></h2>
																					</a>	
																					<div><%=description %></div>
																					<div><span class="bold posted-on"><liferay-ui:message key="posted-on" /></span><span><%=DateUtil.getDate(blog.getDisplayDate(), "dd-MM-yyyy hh:mm a", locale) %></span></div>
		
																					<div class="poll-option">
																					<%
																					if((themeDisplay.isSignedIn() && !hasVoted) || !themeDisplay.isSignedIn()){
																						for (PollsChoice choice : choices) {
																							choice = choice.toEscapedModel();
																					%>
															
																						<aui:field-wrapper cssClass="radio">
																							<aui:input label='<%= choice.getName() + ". " + choice.getDescription(locale) %>' name="choiceId" type="radio" value="<%= choice.getChoiceId() %>" disabled="true" />
																						</aui:field-wrapper>
															
																					<%
																						}
																					}
																					if(hasVoted){
																					%>			
																						<div class="alert alert-success already-voted">
																							<strong><liferay-ui:message key="already-voted" /></strong>
																						</div>
																					<%} %>												
																					</div>	
																					<%if(hasVoted){
																					%>					
																						<a href="<%=pollDisplayUrl%>" class="btn btn-primary"><liferay-ui:message key="view" /></a>
																					<%}else{ %>
																						<a href="<%=pollDisplayUrl%>" class="btn btn-primary"><liferay-ui:message key="read-vote" /></a>
																					<%} %>
																				</div>
																			</div>
																		</div>							
																	</div>	
														<%
														counter++;
														if(counter%4 == 0){
													%>		
																</div>
															</div>	
												<%		}
													}
												}
												%>			
													
												</div>						
											</div>
										</div>				
									</div>
								</div>				
							</div>
						</div>	
					</div>
				</div>				
			</div>
		</div>				
	</div>
</div>	