/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validateur.com;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("VE")
public class ValidEmail implements Validator{
    private static final String EMAIL_MANQUANT    = "Il faut entrer un email !!!";
    private static final String EMAIL_INVALIDE    = "Il faut entrer un email valide !!!";
    private static final String FORME_EMAIL       = "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)";
      @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        if(value == null || "".equals((String)value)){
            FacesMessage erreuremail =new FacesMessage(EMAIL_MANQUANT);
            erreuremail.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(erreuremail);
        }
        
           if ( !((String)value).matches( FORME_EMAIL ) ) {
             FacesMessage erreuremail1 =new FacesMessage(EMAIL_INVALIDE);  
             erreuremail1.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(erreuremail1);
        }
           
           
        
    }
    
}
