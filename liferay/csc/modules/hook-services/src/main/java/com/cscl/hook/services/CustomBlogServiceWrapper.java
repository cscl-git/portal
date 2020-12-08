package com.cscl.hook.services;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.service.ServiceWrapper;
//import com.liferay.blogs.kernel.service;

@Component(
 immediate=true,
 service = ServiceWrapper.class
  )
public class CustomBlogServiceWrapper{

}
