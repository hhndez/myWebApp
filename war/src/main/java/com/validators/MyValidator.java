package com.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ResourceBundle;

import static java.lang.System.*;

@FacesValidator("emailValidator")
public class MyValidator implements javax.faces.validator.Validator {

	private final String RESOURCE = "com.Messages";


	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\." +
			"[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*" +
			"(\\.[A-Za-z]{2,})$";

	private Pattern pattern;
	private Matcher matcher;

	public MyValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	@Override
	public void validate(FacesContext context, UIComponent component,
						 Object value) throws ValidatorException {

		matcher = pattern.matcher(value.toString());
		out.println("Validando...");
		if (!matcher.matches()) {
			out.println("obteniendo mensajes...");
			String m1 = loadErrorMessage(context, RESOURCE, "messageEmail1");
			String m2 = loadErrorMessage(context, RESOURCE, "messageEmail2");
			out.println("Valor m1=" + m1);
			out.println("Valor m2=" + m2);
			FacesMessage msg =
					new FacesMessage(m1, m2);
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);

		}

	}

	private static ResourceBundle bundle;

	public static String loadErrorMessage(FacesContext context,
										  String basename, String key) {

		if (bundle == null) {
			out.println("Cargando bundle");
			try {
				bundle = ResourceBundle.getBundle(basename,
						context.getViewRoot().getLocale());
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		out.println("Regresando key:" + key);
		return bundle.getString(key);

	}

}