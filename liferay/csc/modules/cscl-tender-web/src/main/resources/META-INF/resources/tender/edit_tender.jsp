<%@page import="com.cscl.tender.service.persistence.CsclTenderPersistence"%>
<%@page import="com.cscl.tender.model.CsclTenderCategory"%>
<%@page import="java.util.List"%>
<%@page import="com.cscl.tender.service.CsclTenderCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%@page import="com.cscl.tender.constants.TenderPortletKeys"%>
<%@page import="com.cscl.tender.model.CsclTender"%>
<%@ include file="../init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");

CsclTender tender = (CsclTender)request.getAttribute(TenderPortletKeys.TENDER_CLASS);

long tenderId = BeanParamUtil.getLong(tender, request, "tenderId");
long selectedCatId = BeanParamUtil.getLong(tender, request, "tenderCategoryId");
String description = BeanParamUtil.getString(tender, request, "description");

portletDisplay.setShowBackIcon(true);
portletDisplay.setURLBack(redirect);
%>

<liferay-portlet:actionURL name="/tender/edit_tender" refererPlid="<%=themeDisplay.getRefererPlid()%>" var="editTenderURL">
	<portlet:param name="mvcPath" value="/tender/edit_tender.jsp" />
</liferay-portlet:actionURL>

<aui:form action="<%=editTenderURL%>" cssClass="container-fluid-1280" method="post" name="fm" onSubmit='<%="event.preventDefault(); " + renderResponse.getNamespace() + "saveTender();"%>'>
	<aui:input name="<%=Constants.CMD%>" type="hidden" value="" />
	<aui:input name="redirect" type="hidden" value="<%=redirect%>" />
	<aui:input name="tenderId" type="hidden" value="<%=tenderId%>" />

	<aui:model-context bean="<%=tender%>" model="<%=CsclTender.class%>" />

	<aui:fieldset-group markupView="lexicon">
		<aui:fieldset>
			<aui:input autoFocus="" name="title" />

			<label class="control-label">
				<liferay-ui:message key="description" />
				<span style="color: red;">*</span>
			</label>
			<div class="entry-content form-group">
				<liferay-ui:input-localized xml="<%=description %>" 
					name="description" type="editor"
					editorName="alloyeditor"
					placeholder="description">
				</liferay-ui:input-localized>
			</div>
			
			<aui:select name="tenderCategory" label="category" required="true">
				<aui:option value=""><%=LanguageUtil.get(locale, "select") %></aui:option>
				<%
					try{
						List<CsclTenderCategory> categoryList = CsclTenderCategoryLocalServiceUtil.getCsclTenderCategories(-1, -1);
						if(null != categoryList){
							for(CsclTenderCategory category : categoryList){
				%>
								<aui:option value="<%= category.getTenderCatId() %>" selected='<%=(category.getTenderCatId() == selectedCatId)?true:false%>'><%= category.getCategory(locale) %></aui:option>
				<%
							}
						}
					}catch(Exception e){
						
					}
				%>		
			</aui:select>
			
			<aui:input label="publish-date" name="publishDate" required="true" >
				<aui:validator name="required" />
			</aui:input>
			
			<aui:input label="last-apply-date" name="lastApplyDate" required="true">
				<aui:validator name="required" />
			</aui:input>
			
			<aui:input label="tender-opening-date" name="tenderOpeningDate" required="true">
				<aui:validator name="required" />
			</aui:input>
			<aui:select name="status"required="true">
				<aui:option value="<%=TenderPortletKeys.STATUS_ACTIVE%>"><%=LanguageUtil.get(locale, "active") %></aui:option>
				<aui:option value="<%=TenderPortletKeys.STATUS_INACTIVE%>"><%=LanguageUtil.get(locale, "inactive") %></aui:option>
			</aui:select>
		</aui:fieldset>
		<aui:fieldset collapsed="<%= true %>" collapsible="<%= true %>" label="attachments">
			<div id="<portlet:namespace />attachments">
				<liferay-util:include page="/tender/attachments.jsp" servletContext="<%= application %>" />
			</div>
		</aui:fieldset>
	</aui:fieldset-group>

	<aui:button-row>
		<aui:button type="submit" />
		<aui:button href="<%=redirect%>" type="cancel" />
	</aui:button-row>
</aui:form>

<aui:script>
	function <portlet:namespace />saveTender() {
		var form = document.getElementById('<portlet:namespace />fm');

		if (form) {
			var cmd = form.querySelector('#<portlet:namespace /><%= Constants.CMD %>');

			if (cmd) {
				cmd.setAttribute('value', '<%= (tender == null) ? Constants.ADD : Constants.UPDATE %>');
			}

			submitForm(form);
		}
	}
</aui:script>

<%
if (tender != null) {
	PortalUtil.addPortletBreadcrumbEntry(request, tender.getTitle(locale), null);
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "edit"), currentUrl);
}
else {
	PortalUtil.addPortletBreadcrumbEntry(request, LanguageUtil.get(request, "add-tender"), currentUrl);
}
%>