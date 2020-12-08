<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Group"%>
<%@page import="com.liferay.portal.kernel.service.ClassNameLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.cscl.poll.portlet.util.DLFileUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolder"%>
<%@page import="com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.DateUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.cscl.poll.portlet.util.PollQuestionActionDropdownItemsProvider"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.cscl.poll.portlet.util.CommonUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.cscl.poll.util.comperator.CustomComapatorUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator"%>
<%@page import="com.liferay.polls.service.PollsQuestionLocalServiceUtil"%>
<%@page import="com.liferay.polls.model.PollsQuestion"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.dao.orm.QueryUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.blogs.model.BlogsEntry"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.blogs.service.BlogsEntryServiceUtil"%>
<%@page import="com.cscl.poll.constants.PollPortletKeys"%>
<%@page import="com.cscl.poll.portlet.util.PollUtil"%>
<%@ include file="../init.jsp" %>

<%

String orderByCol = ParamUtil.getString(request, "orderByCol","displayDate"); 
String orderByType = ParamUtil.getString(request, "orderByType","desc");
int pageNo=GetterUtil.getInteger(ParamUtil.getString(request,"cur"));
int itemsPerPage=GetterUtil.getInteger(ParamUtil.getString(request,"delta")); 

int startPagination =1;
int endPagination=20;
if(itemsPerPage != 0){
	if(pageNo != 0){
		startPagination=itemsPerPage*(pageNo-1)+1;
		endPagination=pageNo*itemsPerPage;
	}else{
		endPagination = itemsPerPage;
	}
}
int counter=startPagination;

long pollScopeGroupId=PollUtil.getScopeGroupId(PollPortletKeys.POLL_SCOPE, themeDisplay.getScopeGroupId());
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

if(Validator.isNotNull(blogList)){
    OrderByComparator comparator = CustomComapatorUtil.getOrderByComparator(orderByCol, orderByType);
    ListUtil.sort(blogList, comparator);
}

PortletURL iteratorURL = renderResponse.createRenderURL();
iteratorURL.setParameter("jspPage", "/polls/view.jsp");
iteratorURL.setParameter("orderByCol", orderByCol);
iteratorURL.setParameter("orderByType", orderByType);		

String pollDisplayUrl="";
long layoutClassNameId = ClassNameLocalServiceUtil.getClassNameId(Layout.class.getName());
Group group = null;
Layout blogLayout = null;
%>


<portlet:renderURL var="editURL" windowState="normal">
	<portlet:param name="mvcPath" value="/polls/edit_poll_question.jsp"/>
	<portlet:param name="redirect" value="<%=currentUrl %>"/>
</portlet:renderURL>


<aui:button-row>
	<a class="btn btn-primary btn-default" href="<%= editURL %>">
		<liferay-ui:message key="create-poll" />
	</a>
</aui:button-row>

<aui:form action="" method="post" name="fm1" onSubmit='event.preventDefault();'>

<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" orderByCol="<%= orderByCol %>" orderByType="<%=orderByType %>"  delta="10">
 
<liferay-ui:search-container-results >
    <%
    results = blogList;			    
	total = blogList.size();
	searchContainer.setTotal(results.size());
	pageContext.setAttribute("results", results.subList(searchContainer.getStart(),searchContainer.getResultEnd()));
    pageContext.setAttribute("total", results.size());
    %>
</liferay-ui:search-container-results>
 
    <liferay-ui:search-container-row
        className="com.liferay.blogs.model.BlogsEntry"
        modelVar="blog" keyProperty="entryId">
        
        <%
        String pollId = blog.getExpandoBridge().getAttribute("POLL_ID").toString();
        PollsQuestion question = PollsQuestionLocalServiceUtil.getPollsQuestion(Long.parseLong(pollId));
        
        group = GroupLocalServiceUtil.getGroup(blog.getGroupId());
		if (group.getClassNameId() == layoutClassNameId) {
			blogLayout = LayoutLocalServiceUtil.getLayout(group.getClassPK());
			Group site = GroupLocalServiceUtil.getGroup(blogLayout.getGroupId());
			pollDisplayUrl = site.getPathFriendlyURL(false, themeDisplay) + site.getFriendlyURL() + blogLayout.getFriendlyURL() + "/-/blogs/"
					+ blog.getUrlTitle();
		}
        %>
        
        <liferay-ui:search-container-column-text name="#">
			<span class="pull-right"><%=counter++ %></span>
		</liferay-ui:search-container-column-text>
        <liferay-ui:search-container-column-text orderable="true" name="title" orderableProperty="title" href="<%=pollDisplayUrl %>">
        	<%=question.getTitle(locale)  %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "polls-question") %>">
        	<%=question.getDescription(locale) %>
        </liferay-ui:search-container-column-text>
 
 		<liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "description") %>">
        	<%=StringUtil.shorten(HtmlUtil.render(CommonUtil.getTextFromXml(blog.getContent(), locale)), 100) %>
        </liferay-ui:search-container-column-text>
        
        <liferay-ui:search-container-column-text name="<%=LanguageUtil.get(locale, "publish-date") %>" orderable="true" orderableProperty="displayDate">
        	<%=DateUtil.getDate(blog.getDisplayDate(), "dd-MM-yyyy HH:mm a", locale) %>
        </liferay-ui:search-container-column-text>
 
        <liferay-ui:search-container-column-text>

			<%
				PollQuestionActionDropdownItemsProvider pollEntryActionDropdownItemsProvider = new PollQuestionActionDropdownItemsProvider(blog, renderRequest, renderResponse, permissionChecker, resourceBundle);
			%>

			<clay:dropdown-actions
				dropdownItems="<%= pollEntryActionDropdownItemsProvider.getActionDropdownItems() %>"
			/>
		</liferay-ui:search-container-column-text>
    </liferay-ui:search-container-row>
 
    <liferay-ui:search-iterator />
</liferay-ui:search-container>
</aui:form>

<style>
.taglib-search-iterator-page-iterator-top{
	display: none;
}
</style>