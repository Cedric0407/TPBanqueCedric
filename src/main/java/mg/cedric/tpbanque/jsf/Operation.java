/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.cedric.tpbanque.jsf;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.io.Serializable;
import mg.cedric.tpbanque.ejb.GestionnaireCompte;
import mg.cedric.tpbanque.entities.CompteBancaire;

/**
 *
 * @author CEDRIC
 */
@Named(value = "operation")
@RequestScoped
public class Operation implements Serializable {
    
    private Long id;
    private CompteBancaire compte;
    
    @EJB
    private GestionnaireCompte compteManager;

    /**
     * Creates a new instance of Operation
     */
    public Operation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CompteBancaire getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaire compte) {
        this.compte = compte;
    }
    
    
    
    public void loadCompte(){
        System.out.println("loadCompte");
        compte = compteManager.findById(id);
    }
    
}
