/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package mg.cedric.tpbanque.jsf;

import jakarta.ejb.EJB;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import mg.cedric.tpbanque.ejb.GestionnaireCompte;
import mg.cedric.tpbanque.entities.CompteBancaire;
import mg.cedric.tpbanque.jsf.util.Util;

/**
 *
 * @author CEDRIC
 */
@Named(value = "listCompteBean")
@ViewScoped
public class ListeComptes implements Serializable {

    @EJB
    private GestionnaireCompte compteManager;
    private List<CompteBancaire> allComptes;

    /**
     * Creates a new instance of CompteBean
     */
    public ListeComptes() {
    }

    public List<CompteBancaire> getAllComptes() {
        if (allComptes == null) {
            allComptes = compteManager.getAllComptes();
        }
        return allComptes;
    }

    public String supprimerCompte(CompteBancaire compteBancaire) {
        compteManager.supprimerCompte(compteBancaire);
        Util.addFlashInfoMessage("Compte de " + compteBancaire.getNom() + " supprimé");
        return "listeComptes?faces-redirect=true";
    }

}
