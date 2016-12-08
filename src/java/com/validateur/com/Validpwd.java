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

@FacesValidator("VPwd")
public class Validpwd implements Validator{
     private static final String MOT_DE_PASSE_MANQUANTE    = "Il faut entrer un mot de passe !!!";
     private static final String MOTS_DE_PASSE_COURTE      = "Il faut entrer un mot de passe de longueur superieur ou egale à 8 !!!";
     private static final String FORME_MOT_DE_PASSE        = ".*(?=.{8,})(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z]).*" ;
     private static final String MOT_DE_PASSE_FAIBLE       = "Le mot de passe est très faible il faut utiliser different type de caractère et des chiffres";
      @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        if(value == null || "".equals((String)value)){
            FacesMessage erreurpwd =new FacesMessage(MOT_DE_PASSE_MANQUANTE );
            erreurpwd.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(erreurpwd);
        }
        
         
        if(value.toString().length() < 8){
            FacesMessage erreurpwd =new FacesMessage(MOTS_DE_PASSE_COURTE);
            erreurpwd.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(erreurpwd);
        }
        
        
        if( !((String)value).matches( FORME_MOT_DE_PASSE )){
            FacesMessage erreurpwd =new FacesMessage(MOT_DE_PASSE_FAIBLE );
            erreurpwd.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(erreurpwd);
        }
        
    }
}
