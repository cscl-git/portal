<%@page import="com.cscl.tender.constants.TenderPortletKeys"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.document.library.configuration.DLConfiguration"%>
<%@page import="com.liferay.portal.kernel.module.configuration.ConfigurationProviderUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.portletfilerepository.PortletFileRepositoryUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="java.util.ArrayList"%>
<%@ include file="/init.jsp" %>

<%
	long resourcePrimKey =0;
List<FileEntry> attachmentsFileEntries = new ArrayList<FileEntry>();

%>

<div class="tender-attachments">
	<aui:input name="removeFileEntryIds" type="hidden" />

	<div class="lfr-dynamic-uploader">
		<div class="lfr-upload-container" id="<portlet:namespace />fileUpload"></div>
	</div>

	<span id="<portlet:namespace />selectedFileNameContainer"></span>

	<div class="hide" id="<portlet:namespace />metadataExplanationContainer"></div>

	<div class="hide selected" id="<portlet:namespace />selectedFileNameMetadataContainer"></div>

	<c:if test="<%=!attachmentsFileEntries.isEmpty()%>">
		<h4><liferay-ui:message key="saved-attachments" /></h4>

		<div id="<portlet:namespace />existingAttachmentsContainer">

			<%
				for (FileEntry fileEntry : attachmentsFileEntries) {
			%>

				<div id="<portlet:namespace />fileEntryIdWrapper<%=fileEntry.getFileEntryId()%>">

					<%
						String rowURL = PortletFileRepositoryUtil.getDownloadPortletFileEntryURL(themeDisplay, fileEntry, "status=" + WorkflowConstants.STATUS_APPROVED);
					%>

					<liferay-ui:icon
						iconCssClass="icon-paper-clip"
						label="<%=true%>"
						message='<%=HtmlUtil.escape(fileEntry.getTitle()) + " (" + TextFormatter.formatStorageSize(fileEntry.getSize(), locale) + ")"%>'
						method="get"
						url="<%=rowURL%>"
					/>

					<%
						String taglibURL = "javascript:" + renderResponse.getNamespace() + "deleteFileEntry('" + fileEntry.getFileEntryId() + "');";
					%>

					<liferay-ui:icon-delete
						label="<%=true%>"
						url="<%=taglibURL%>"
					/>
				</div>

			<%
				}
			%>

		</div>
	</c:if>
</div>

<aui:script use="liferay-upload">
	new Liferay.Upload(
		{
			boundingBox: '#<portlet:namespace />fileUpload',
			deleteFile: '<liferay-portlet:actionURL name="deleteTempAttachment"><portlet:param name="resourcePrimKey" value="<%=String.valueOf(resourcePrimKey)%>" /></liferay-portlet:actionURL>',

			<%
	DLConfiguration dlConfiguration = ConfigurationProviderUtil.getSystemConfiguration(DLConfiguration.class);
%>

			fileDescription: '<%=StringUtil.merge(dlConfiguration.fileExtensions())%>',
			maxFileSize: '<%=dlConfiguration.fileMaxSize()%> B',
			metadataContainer: '#<portlet:namespace />selectedFileNameMetadataContainer',
			metadataExplanationContainer: '#<portlet:namespace />metadataExplanationContainer',
			namespace: '<portlet:namespace />',
			tempFileURL: {
				method: Liferay.Service.bind('/dlapp/get-temp-file-names'),
				params: {
					groupId: <%=scopeGroupId%>,
					folderId: <%=DLFolderConstants.DEFAULT_PARENT_FOLDER_ID%>,
					folderName: '<%=TenderPortletKeys.TEMP_FOLDER_NAME%>'
				}
			},
			uploadFile: '<liferay-portlet:actionURL name="addTempAttachment"><portlet:param name="resourcePrimKey" value="<%= String.valueOf(resourcePrimKey) %>" /></liferay-portlet:actionURL>'
		}
	);
</aui:script>

<aui:script>
	Liferay.provide(
		window,
		'<portlet:namespace />deleteFileEntry',
		function(fileEntryId) {
			var A = AUI();

			var removeFileEntryIdsInput = A.one('#<portlet:namespace />removeFileEntryIds');

			var fileEntries = removeFileEntryIdsInput.val();

			if (fileEntries.length) {
				fileEntries += ',';
			}

			fileEntries += fileEntryId;

			removeFileEntryIdsInput.val(fileEntries);

			var fileEntryIdWrapper = A.one('#<portlet:namespace />fileEntryIdWrapper' + fileEntryId);

			if (fileEntryIdWrapper) {
				fileEntryIdWrapper.hide();
			}
		},
		['aui-base']
	);
</aui:script>