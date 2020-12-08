<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.document.library.util.DLURLHelperUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page import="com.liferay.document.library.kernel.util.VideoProcessorUtil"%>
<%@page import="com.liferay.document.library.kernel.util.PDFProcessorUtil"%>
<%@page import="com.liferay.document.library.kernel.util.ImageProcessorUtil"%>
<%@page import="com.liferay.document.library.kernel.util.AudioProcessorUtil"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileVersion"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolder"%>
<%@page import="com.liferay.portal.kernel.repository.model.FileEntry"%>
<%@page import="com.liferay.document.library.kernel.service.DLAppServiceUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.cscl.home.gallery.constants.HomeGalleryPortletKeys"%>
<%@page import="com.liferay.document.library.kernel.model.DLFolderConstants"%>
<%@page import="com.liferay.document.library.kernel.service.DLFolderLocalServiceUtil"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<link href="<%=request.getContextPath() %>/css/video-js.css" rel="stylesheet" />

<%
DLFolder folder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID, HomeGalleryPortletKeys.GALLERY_FOLDER_NAME);

List<FileEntry> galleryList = null;

if(null != folder){
	galleryList = DLAppServiceUtil.getGroupFileEntries(themeDisplay.getScopeGroupId(), 0, folder.getFolderId(), 0, SearchContainer.MAX_DELTA);
}
int counter=0 ;
String activeCssClass="active";
%>
<div id="news-letter" class="text-center parallax-section gallery-responsive">
	<div class="parallax-content">
		<div class="container">
			<div class="col-md-12">
				<div class="our-tea text-left padding-bottom wow zoomIn animated" data-wow-duration="700ms" data-wow-delay="300ms" style="visibility: visible; animation-duration: 700ms; animation-delay: 300ms; animation-name: zoomIn;">
					<h2 class="text-center heading"><liferay-ui:message key="pictury-video-gallery" /></h2>
					<div id="team-carousel" class="carousel slide" data-ride="carousel">
						<a class="team-carousel-left" href="#team-carousel" data-slide="prev"><i class="fa fa- fa-chevron-left"></i></a>
						<a class="team-carousel-right" href="#team-carousel" data-slide="next"><i class="fa fa- fa-chevron-right"></i></a>
						<div class="carousel-inner">
						<%
						if(null != galleryList && !galleryList.isEmpty()){
							for(FileEntry fileEntry : galleryList){
								if(fileEntry == null){
									continue;
								}
								if(counter != 0){
									activeCssClass="";
								}
								if(counter%4 == 0){
						%>
									<div class="item carousel-item <%=activeCssClass%>">
										<div class="row">
							<%	} %>	
							<%
								String dataOptions = StringPool.BLANK;
	
								FileVersion fileVersion = fileEntry.getFileVersion();
								//System.out.println("fileVersion:"+fileVersion);
								boolean hasAudio = AudioProcessorUtil.hasAudio(fileVersion);
								boolean hasImages = ImageProcessorUtil.hasImages(fileVersion);
								boolean hasPDFImages = PDFProcessorUtil.hasImages(fileVersion);
								boolean hasVideo = VideoProcessorUtil.hasVideo(fileVersion);
								String imagePreviewURL = null;
								String imageURL = themeDisplay.getPathThemeImages() + "/file_system/large/" + DLUtil.getGenericName(fileEntry.getExtension()) + ".png";
								int playerHeight = 500;
	
								String thumbnailId = "entry_" + fileEntry.getFileEntryId();
								if (GetterUtil.getBoolean(PropsUtil.get("dl.file.entry.preview.enabled"))) {
									if (hasAudio) {
										for (String audioContainer : PropsUtil.getArray("dl.file.entry.preview.audio.containers")) {
											dataOptions += "&" + audioContainer + "PreviewURL=" + HtmlUtil.escapeURL(DLURLHelperUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, "&supportedAudio=1&audioPreview=1&type=" + audioContainer));
										}
	
										imagePreviewURL = DLURLHelperUtil.getImagePreviewURL(fileEntry, fileVersion, themeDisplay);
										imageURL = DLURLHelperUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, HtmlUtil.escapeURL("&audioPreview=1") + "&supportedAudio=1&mediaGallery=1");
										playerHeight = 43;
									}
									else if (hasImages) {
										imagePreviewURL = DLURLHelperUtil.getThumbnailSrc(fileEntry, fileVersion, themeDisplay);
										imageURL = DLURLHelperUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, "&imagePreview=1");
									}
									else if (hasPDFImages) {
										imagePreviewURL = DLURLHelperUtil.getImagePreviewURL(fileEntry, fileVersion, themeDisplay);
										imageURL = DLURLHelperUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, "&previewFileIndex=1");
									}
									else if (hasVideo) {
										for (String videoContainer : PropsUtil.getArray("dl.file.entry.preview.video.containers")) {
											dataOptions += "&" + videoContainer + "PreviewURL=" + HtmlUtil.escapeURL(DLURLHelperUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, "&supportedVideo=1&videoPreview=1&type=" + videoContainer));
										}
	
										imagePreviewURL = DLURLHelperUtil.getImagePreviewURL(fileEntry, fileVersion, themeDisplay);
										imageURL = DLURLHelperUtil.getPreviewURL(fileEntry, fileVersion, themeDisplay, "&supportedVideo=1&mediaGallery=1");
										playerHeight = GetterUtil.getInteger(PropsUtil.get("dl.file.entry.preview.video.height"));
									}
								}
	
								String title = fileEntry.getTitle();
								String description="";
								if (Validator.isNotNull(fileEntry.getDescription())) {
									description = fileEntry.getDescription();
								}
							%>	
											<div class="col-md-6 col-lg-3">
												<div class="team-member">
													<div class="member-image">
														<%if(hasVideo){ %>
															<!-- <video height="180" width="100%" controls> -->
															<a href="<%= imageURL %>" title="<%= HtmlUtil.escapeAttribute(title) %>"
																class="html5lightbox" data-group="gallerygroup" data-thumbnail="<%=Validator.isNotNull(imagePreviewURL)?imagePreviewURL:imageURL %>">
																<%-- <video
																    id="gallery-video"
																    class="video-js vjs-theme-sea"
																    controls
																    preload="auto"
																    width="100%"
																    height="180"
																    poster="<%=imagePreviewURL %>"
																    data-setup="{}"
																  >
																	<source src="<%=imageURL %>" type="<%=fileEntry.getMimeType()%>">
																</video> --%>
																<div class="video-js vjs-theme-sea vjs-paused gallery-video-dimensions vjs-controls-enabled vjs-workinghover vjs-v7 vjs-user-active" id="gallery-video" tabindex="-1" role="region" lang="en-us" aria-label="Video Player">
																	<button class="vjs-big-play-button" type="button" title="Play Video" aria-disabled="false"><span aria-hidden="true" class="vjs-icon-placeholder"></span><span class="vjs-control-text" aria-live="polite">Play Video</span></button>
																	<img class="img-fluid" src="<%=Validator.isNotNull(imagePreviewURL)?imagePreviewURL:imageURL %>" thumbnailId="<%= thumbnailId %>" alt="<%= HtmlUtil.escapeAttribute(title) %>">
																</div>																
															</a>
														<%}else{ %>
														<a href="<%= imageURL %>" title="<%= HtmlUtil.escapeAttribute(title) %>"
															class="html5lightbox" data-group="gallerygroup" data-thumbnail="<%=Validator.isNotNull(imagePreviewURL)?imagePreviewURL:imageURL %>">
															<img class="img-fluid" src="<%=Validator.isNotNull(imagePreviewURL)?imagePreviewURL:imageURL %>" thumbnailId="<%= thumbnailId %>" alt="<%= HtmlUtil.escapeAttribute(title) %>">
														</a>
														<%} %>
													</div>
													<%-- <div class="csc-overlay">
														<h4><%=title %></h4>
														<p><%=description %></p>
														<ul class="social-icons">
															<li><a href="#"><i class="fa fa-facebook"></i></a></li>
															<li><a href="#"><i class="fa fa-twitter"></i></a></li>
															<li><a href="#"><i class="fa fa-google-plus"></i></a></li>
															<li><a href="#"><i class="fa fa-linkedin"></i></a></li>
														</ul>
													</div> --%>
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

<style>
#gallery-video{
	width:100%;
}
#html5-watermark,.html5-title-caption{
	display:none !important;
}
.html5-image{
	padding:1px !important;
}
</style>
<script src="<%=request.getContextPath() %>/js/videojs-ie8.min.js"></script>
<script src="<%=request.getContextPath() %>/js/video.js"></script>
<script src="<%=request.getContextPath() %>/js/html5lightbox.js"></script>