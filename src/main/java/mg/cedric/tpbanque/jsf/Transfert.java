/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.cedric.tpbanque.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.application.FacesMessage.Severity;
import jakarta.faces.context.FacesContext;
import mg.cedric.tpbanque.ejb.GestionnaireCompte;
import mg.cedric.tpbanque.entities.CompteBancaire;

/**
 *
 * @author CEDRIC
 */
@Named(value = "transfert")
@RequestScoped
public class Transfert {
    
    private int idSource;
    private int idDestination;
    private int montant;
    
    @EJB
    private GestionnaireCompte compteManager ;
    

    /**
     * Creates a new instance of Transfert
     */
    public Transfert() {
    }

    public int getIdSource() {
        return idSource;
    }

    public void setIdSource(int idSource) {
        this.idSource = idSource;
    }

    public int getIdDestination() {
        return idDestination;
    }

    public void setIdDestination(int idDestination) {
        this.idDestination = idDestination;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
    
    public String submitTransfert(){
        CompteBancaire compteSource = compteManager.findById(idSource);
        CompteBancaire compteDestination = compteManager.findById(idDestination);
        compteManager.transferer(compteSource, compteDestination, montant);
        return "listeComptes?faces-redirect=true";
        
        
    }
    
}
