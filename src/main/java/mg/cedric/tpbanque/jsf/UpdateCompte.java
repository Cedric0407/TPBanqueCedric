/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.cedric.tpbanque.jsf;

import jakarta.ejb.EJB;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.component.UIInput;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import mg.cedric.tpbanque.ejb.GestionnaireCompte;
import mg.cedric.tpbanque.entities.CompteBancaire;
import mg.cedric.tpbanque.jsf.util.Util;

/**
 *
 * @author CEDRIC
 */
@Named(value = "updateCompte")
@ViewScoped
public class UpdateCompte implements Serializable {

    private int id;
    private CompteBancaire compte;

    @EJB
    private GestionnaireCompte compteManager;

    /**
     * Creates a new instance of UpdateCompte
     */
    public UpdateCompte() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }

    public void loadCompte() {
        compte = compteManager.findById(id);
        System.out.println(compte);
    }

    // La méthode doit avoir cette signature.
    public void validateSolde(FacesContext fc, UIComponent composant, Object valeur) {
        int solde = (int) valeur;
        if (solde < 0) {
            FacesMessage message
                    = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Le solde doit être un supérieur à 0",
                            "Le solde doit être un supérieur à 0");
            throw new ValidatorException(message);
        }
    }

    public String submitAction() {
        System.out.println("ato loadCompte");
        compteManager.update(compte);
        Util.addFlashInfoMessage("Modification enregistré sur compte de " + compte.getNom());
        return "listeComptes?faces-redirect=true";
    }
}
