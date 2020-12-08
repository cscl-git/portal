<#assign currentUrl = themeDisplay.getLayout().getFriendlyURL()?remove_beginning("/") />
<#assign pageUrl = themeDisplay.getPortalURL() + themeDisplay.getURLCurrent() />

<#assign home_css_class = "" />
<#if currentUrl?contains("home")>
    <#assign is_home_page = true />
    <#assign home_css_class = "home" />
    <#assign pageUrl = themeDisplay.getPortalURL() />
<#else>
	<#assign is_home_page = false />
</#if>


<#assign IS_FULL_PAGE = false />
<#if validator.isNotNull(themeDisplay.getLayout().getExpandoBridge()) >
    <#assign IS_FULL_PAGE = themeDisplay.getLayout().getExpandoBridge().getAttribute('IS_FULL_PAGE') />
</#if>

<#if !is_home_page && !IS_FULL_PAGE>
	<#assign portal_content_css_class = "container mt-4 inner-bg" />
<#else>
	<#assign portal_content_css_class = "" />
</#if>


<#assign after_login_css_class = "" />
<#assign menu_bar_css_class = "" />
<#if is_signed_in>
    <#assign roles = user.getRoles() />
    <#list roles as role>
          <#if role.getName() == "Administrator" || role.getName() == "Employee">
				<#assign after_login_css_class = "afterlogin-top" />
				<#assign menu_bar_css_class = "menu-bar-top" />
				<#break>
        </#if>             
    </#list>
</#if>

<#assign imageLogo = themeDisplay.getPortalURL() + site_logo/>
<#assign pageDescription = themeDisplay.getLayout().getDescription(locale)/>
<#assign pageKeywords = themeDisplay.getLayout().getKeywords(locale)/>