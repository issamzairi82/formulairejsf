/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.validateur.com;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("VC")
public class ValidConf implements Validator{
    private static final String CONF_COURTE      = "Il faut entrer une confirmation de longueur superieur ou egale à 8 !!!";  
    private static final String CONF_MANQUANTE    = "Il faut entrer la confirmation !!";
    @Override
    @SuppressWarnings("null")
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
       
       if(value == null || "".equals((String)value)){
            FacesMessage erreurconf =new FacesMessage(CONF_MANQUANTE );
            erreurconf.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(erreurconf);
        }
        
         
        if(value.toString().length() < 8){
            FacesMessage erreurconf =new FacesMessage(CONF_COURTE);
            erreurconf.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(erreurconf);
        }
        
    
      
    }
    
}
