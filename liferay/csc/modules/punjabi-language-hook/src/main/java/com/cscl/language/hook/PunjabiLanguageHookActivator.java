package com.cscl.language.hook;

import java.util.Enumeration;
import java.util.ResourceBundle;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.language.UTF8Control;

@Component(
		 property = { "language.id=pa_IN" }, 
		 service = ResourceBundle.class
		)
public class PunjabiLanguageHookActivator extends ResourceBundle {
	 
	ResourceBundle bundle = ResourceBundle.getBundle("content.Language_pa_IN", UTF8Control.INSTANCE);

	@Override
	protected Object handleGetObject(String key) {
		return bundle.getObject(key);
	}

	@Override
	public Enumeration<String> getKeys() {
		return bundle.getKeys();
	}

}