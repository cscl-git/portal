<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="CSCL">
	<meta name="generator" content="CSCL">
	<link rel="shortcut icon" href="${images_folder}/favicon.ico" type="image/x-icon">

	<title>${the_title} - ${company_name}</title>

	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<meta property="og:site_name" content="${site_name}" />
	<meta property="og:url" content="${pageUrl}" />
	<meta property="og:type" content="website" />
	<meta property="og:title" content="${the_title}" />
	<meta property="og:image" content="${imageLogo}" />
	<meta property="og:description" content="${pageDescription}" />
	
	<meta name="twitter:url" content="${pageUrl}">
	<meta name="twitter:card" content="summary"/>
	<meta name="twitter:site" content="CSCL">
	<meta name="twitter:site:id" content="CSCL">
	<meta name="twitter:creator" content="CSCL">
	<meta name="twitter:title" content="${the_title}" />
	<meta name="twitter:description" content="${pageDescription}" />
	<meta name="twitter:image:src" content="${imageLogo}">
	<meta name="MobileOptimized" content="width">
	<meta name="HandheldFriendly" content="true">
	<link rel="shortlink" href="${pageUrl}">

	<@liferay_util["include"] page=top_head_include />

	<script async src="https://www.googletagmanager.com/gtag/js?id=UA-164526348-1"></script>
	<script>
		window.dataLayer = window.dataLayer || [];
		function gtag(){dataLayer.push(arguments);}
		gtag('js', new Date());
		gtag('config', 'UA-164526348-1');
	</script>

    <link href="${css_folder}/animate.css" rel="stylesheet" type="text/css">
    <link href="${css_folder}/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="${css_folder}/font.css" rel="stylesheet" type="text/css">
    <link href="${css_folder}/slider.css" rel="stylesheet" type="text/css">
	<link href="${css_folder}/style.css" rel="stylesheet" type="text/css">
	<link href="${css_folder}/responsive.css" rel="stylesheet" type="text/css">

	<script src="${javascript_folder}/jquery.js"></script>
	<script type="text/javascript">
    	dnjq = jQuery.noConflict(true);
  	</script>
</head>

<body class="${css_class}">

<@liferay_ui["quick-access"] contentId="#main-content" />

<@liferay_util["include"] page=body_top_include />

<@liferay.control_menu />

<div class="loader PageLoader">
	<div class="logoLoader"></div>
</div>
<div class="ajaxLoader" style="display:none">
	<div class="ajaxLogoLoader"></div>
</div>

<header id="navigation">
	<div class="navbar main-nav navbar-expand-lg ${after_login_css_class}" role="banner">
		<div class="container">
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"><i class="fa fa-align-justify"></i></span>
			</button>
			<a class="navbar-brand" href="${site_default_url}" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
				<h1><img class="img-fluid" src="${images_folder}/custom_images/chandigarh-logo.png" alt="logo"></h1>
			</a>
			<div class="top-bar">
				<#--  <span><a href="#skipMain">${languageUtil.get(locale, "skip-to-main-content")}</a></span>  -->
				<span style="display:none"><a href="#"><div class="bluebx"></div></a></span>
				<span style="display:none"><a href="#"><div class="yellowbx"></div></a></span>
				<span class="language-bar" style="display:none">
					<#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone", "displayStyle", "ddmTemplate_LANGUAGE-LONG-TEXT-FTL"}) />
					<@liferay.languages default_preferences="${preferences}" />
				</span>
				<span><a href="javascript:void(0);" class="font-button plus">${languageUtil.get(locale, "a-title-plus")}</a></span>
				<span><a href="javascript:void(0);" class="font-button reset">${languageUtil.get(locale, "a-title")} </a></span>
				<span><a href="javascript:void(0);" class="font-button minus">${languageUtil.get(locale, "a-title-minus")}</a></span>
				<#if is_signed_in>
					<span><a href="${sign_out_url}">${sign_out_text}</a></span>
				<#else>
					<span><a href="/sign-in">${languageUtil.get(locale, "login")}</a></span>
				</#if>
			</div>
			<div class="other-site-logo">
				<a class="pdr-10" href="http://chandigarh.gov.in/" target="_blank" title="The official website of the Chandigarh Administration">
					<img src="${images_folder}/custom_images/chdadmin-logo.png" alt="The official website of the Chandigarh Administration">
				</a>
				<a href="http://mcchandigarh.gov.in/" target="_blank" title="The official website of Municipal Corporation Chandigarh, Government of Punjab, India">
					<img src="${images_folder}/custom_images/mc-chandigardh-logo.png" alt="The official website of Municipal Corporation Chandigarh, Government of Punjab, India">
				</a>
			</div>
			<#include "${full_templates_path}/navigation.ftl" />
			<div class="search">
				<a href="javascript:void(0)" id="srch"><i class="fa fa-search"></i></a>
			</div>
		</div>
	</div>
</header><!--/#navigation--> 

<#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone", "destination": "/search"}) />
<div class="osb-search-container search-box" id="search-box" style="display:none;">	
	<div class="row">
		<div class="search-container col-11">
			<@liferay.search_bar default_preferences="${preferences}" />
		</div>
		<svg class="close-icon col-1" height="20" width="20" viewBox="0 0 25.102 25.145" id="closeSrch">
			<path d="M24.573 24.614L.53.572M.53 24.572L24.573.53" fill="none" stroke="currentColor" stroke-miterlimit="10" stroke-width="2"></path>
		</svg>		
	</div>
</div>

<#if !is_home_page>
	<div id="menu_banner" class="menu-banner ${menu_bar_css_class}">
		<#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone"}) />
		<@liferay_portlet["runtime"]
			defaultPreferences="${preferences}"
			portletProviderAction=portletProviderAction.VIEW
			instanceId="menu_banner"
			portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
	</div>	
</#if>

<section class="${portal_content_css_class}" id="content">
	<div class="main-body-container">
		<h1 class="hide-accessible">${the_title}</h1>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</div>
</section>

<div class="footer-area ${home_css_class}">
	<#assign preferences = freeMarkerPortletPreferences.getPreferences({"portletSetupPortletDecoratorId": "barebone"}) />
	<@liferay_portlet["runtime"]
		defaultPreferences="${preferences}"
		portletProviderAction=portletProviderAction.VIEW
		instanceId="contact_us"
		portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />

	<@liferay_portlet["runtime"]
		defaultPreferences="${preferences}"
		portletProviderAction=portletProviderAction.VIEW
		instanceId="footer"
		portletName="com_liferay_journal_content_web_portlet_JournalContentPortlet" />
</div>

<@liferay_util["include"] page=body_bottom_include />

<@liferay_util["include"] page=bottom_include />


<script src="${javascript_folder}/jquery.parallax.js"></script>
<script src="${javascript_folder}/wow.min.js"></script>
<script src="${javascript_folder}/themeregion_main.js"></script>	

<script type="text/javascript">
	$(function () {
		$("#navbarNav .lfr-nav-item").mouseover(function(){
			$(this).addClass("hover open");
		});
		$("#navbarNav .lfr-nav-item").mouseout(function(){
			$(this).removeClass('hover open');
		});
		$("#navbarNav .lfr-nav-item").click(function(){
			if(!$(this).prev("#navbarNav").hasClass("show")){
				$("#navbarNav").addClass("show");
			}
		});
	});
	$(function () {
		$(".language-entry-long-text").each( function( index, element ){
			$(this).text($(this).text().replace("अंग्रेजी","English").replace("[beta]","").replace("panjabi","ਪੰਜਾਬੀ"));
		});
	});
	$(function () {
		var currentFont = parseInt($('.main-body-container').css('font-size'));
		$(".font-button").bind("click", function () {
			var size = parseInt($('.main-body-container').css("font-size"));
			console.log("size:"+size);
			if ($(this).hasClass("plus")) {
				size = size + 1;
				if (size >= currentFont + 3) {
					size = currentFont + 3;
				}
			} else if ($(this).hasClass("minus")) {
				size = size - 1;
				if (size <= currentFont - 3) {
					size = currentFont - 3;
				}
			}else{
				size = currentFont;
			}
			$('.main-body-container').css("font-size", size);
			$('.footer-area').css("font-size", size);			
		});
	});

	$(function () {
		$("#srch").click(function(){
			$(".search-box").toggle(300);
		});		
		$("#closeSrch").click(function(){
			$("#search-box").css('display','none');
		});

		// Add minus icon for collapse element which is open by default
        $(".collapse.show").each(function(){
        	$(this).prev(".card-header").find(".fa").addClass("fa-minus").removeClass("fa-plus");
        });
        
        // Toggle plus minus icon on show hide of collapse element
        $(".collapse").on('show.bs.collapse', function(){
        	$(this).prev(".card-header").find(".fa").removeClass("fa-plus").addClass("fa-minus");
        }).on('hide.bs.collapse', function(){
        	$(this).prev(".card-header").find(".fa").removeClass("fa-minus").addClass("fa-plus");
        });
	});
	<#--  $( window ).on( "load", function() {
        $(window).scrollTop(0);
		$(".loader").delay(350).fadeOut("slow");
    });  -->
	$( document ).ready(function() {
         $(window).scrollTop(0);
		$(".loader").delay(350).fadeOut("slow");
    });
</script>

</body>

</html>