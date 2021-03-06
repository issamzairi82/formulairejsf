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

@FacesValidator("VN")
public class ValidNom implements Validator {
    private static final String NOM_MANQUANT    = "Il faut entrer un nom !!!";
     private static final String NOM_COURT      = "Il faut entrer un nom de longueur superieur ou egale à 3 !!!";
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        if(value == null || "".equals((String)value)){
            FacesMessage erreurnom =new FacesMessage(NOM_MANQUANT);
            erreurnom.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(erreurnom);
        }
        
        if(value.toString().length() < 3){
            FacesMessage erreurn =new FacesMessage(NOM_COURT);
            erreurn.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(erreurn);
        }
    }
    
}
