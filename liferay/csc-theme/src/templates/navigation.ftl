<nav class="${nav_css_class} collapse navbar-collapse navbar-right justify-content-end" id="navbarNav" role="navigation">
	<h1 class="hide-accessible"><@liferay.language key="navigation" /></h1>

	<ul class="nav navbar-nav" aria-label="<@liferay.language key="site-pages" />" role="menubar">
		<#list nav_items as nav_item>
			<#assign
				nav_item_attr_has_popup = ""
				nav_item_css_class = "lfr-nav-item nav-item scroll"
				nav_item_layout = nav_item.getLayout()
			/>

			<#if nav_item.isSelected()>
				<#assign
					nav_item_attr_has_popup = "aria-haspopup='true'"
					nav_item_css_class = "lfr-nav-item nav-item scroll selected"
				/>
			</#if>

			<#if nav_item.hasChildren()>
				<#assign
					nav_item_css_class = nav_item_css_class+ " dropdown"
				/>
			</#if>

			<#if nav_item.getURL()?contains("about-us")>
				<#assign page_url = "javascript:void(0)" />			
			<#elseif nav_item.getURL()?contains("contact-us")>
				<#assign page_url = "#contact-us" />
			<#else>
				<#assign page_url = nav_item.getURL() />
			</#if>

			<li class="${nav_item_css_class}" id="layout_${nav_item.getLayoutId()}" role="presentation" title="${nav_item.getTitle()}">
				<a aria-labelledby="layout_${nav_item.getLayoutId()}" ${nav_item_attr_has_popup} href="${page_url}" ${nav_item.getTarget()} role="menuitem" title="${nav_item.getTitle()}">
					<span><@liferay_theme["layout-icon"] layout=nav_item_layout /> ${nav_item.getName()}</span>
				</a>

				<#if nav_item.hasChildren()>
					<ul class="child-menu dropdown-menu" role="menu">
						<#list nav_item.getChildren() as nav_child>
							<#assign
								nav_child_css_class = ""
							/>

							<#if nav_child.isSelected()>
								<#assign
									nav_child_css_class = "selected"
								/>
							</#if>

							<li class="${nav_child_css_class}" id="layout_${nav_child.getLayoutId()}" role="presentation" title="${nav_child.getTitle()}">
								<a aria-labelledby="layout_${nav_child.getLayoutId()}" href="${nav_child.getURL()}" ${nav_child.getTarget()} role="menuitem" title="${nav_child.getTitle()}">${nav_child.getName()}</a>
							</li>
						</#list>
					</ul>
				</#if>
			</li>
		</#list>
	</ul>
</nav>