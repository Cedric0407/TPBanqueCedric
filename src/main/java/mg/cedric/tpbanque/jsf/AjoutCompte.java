/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.cedric.tpbanque.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import mg.cedric.tpbanque.ejb.GestionnaireCompte;
import mg.cedric.tpbanque.entities.CompteBancaire;
import mg.cedric.tpbanque.jsf.util.Util;

/**
 *
 * @author CEDRIC
 */
@Named(value = "ajoutCompte")
@RequestScoped
public class AjoutCompte {
    @NotNull(message = "Nom est obligatoire")
    private String nom;
    
    @PositiveOrZero
    private int solde;
    
    @EJB
    private GestionnaireCompte compteManager ;

    /**
     * Creates a new instance of AjoutCompte
     */
    public AjoutCompte() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getSolde() {
        return solde;
    }

    public void setSolde(int solde) {
        this.solde = solde;
    }

    public String submitAction() {
        
        if(nom.length() != 0 && solde >= 0){
            
            FacesMessage.Severity severityUpdate = null;  
            String summaryUpdate = "";
            String messageUpdate = "";
            FacesMessage.Severity severity = FacesMessage.SEVERITY_ERROR;
            String nextUrl= "listeComptes?faces-redirect=true";
            try{
                compteManager.creerCompte(new CompteBancaire(nom , solde));
                severity = FacesMessage.SEVERITY_INFO;
                summaryUpdate = "Le compte de " + this.nom + " a été enregistré";
            }catch(Exception e){
                severity = FacesMessage.SEVERITY_ERROR;
                summaryUpdate = "saving failed";
                messageUpdate = e.getMessage();
                nextUrl = "";

            }finally{
                FacesMessage facesMessage = new FacesMessage(severity, summaryUpdate, messageUpdate);
                Util.addFlashMessage(facesMessage);
                return nextUrl;
            }
                        
        }
            
        return null;
    }

    
    
}
