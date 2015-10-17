package com.grinyov.library.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.util.ArrayList;
import java.util.ResourceBundle;

/**
 * Created by Grinyov Vitaliy on 15.10.15.
 *
 * Класс-валидатор, проверяющий корректность ввода
 */
@FacesValidator("ru.javabegin.training.web.validators.LoginValidator")
public class LoginValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

        ResourceBundle bundle = ResourceBundle.getBundle("ru.javabegin.training.web.nls.messages", FacesContext.getCurrentInstance().getViewRoot().getLocale());

        try {
            String newValue = value.toString();

            if (newValue.length() < 5) {
                throw new IllegalArgumentException(bundle.getString("login_length_error"));
            }

            if (!Character.isLetter(newValue.charAt(0))) {
                throw new IllegalArgumentException(bundle.getString("first_letter_error"));
            }

            if (getTestArray().contains(newValue)) {
                throw new IllegalArgumentException(bundle.getString("used_name"));
            }


        } catch (IllegalArgumentException e) {
            FacesMessage message = new FacesMessage(e.getMessage());
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }

    }

    private ArrayList<String> getTestArray() {
        ArrayList<String> list = new ArrayList<String>();// Р·Р°РіР»СѓС€РєР°, Р¶РµР»Р°С‚РµР»СЊРЅРѕ РґРµР»Р°С‚СЊ Р·Р°РїСЂРѕСЃ РІ Р±Р°Р·Сѓ РґР°РЅРЅС‹С… РґР»СЏ РїСЂРѕРІРµСЂРєРё СЃСѓС‰РµСЃС‚РІСѓСЋС‰РµРіРѕ РёРјРµРЅРё
        list.add("username");
        list.add("login");
        return list;
    }

}
