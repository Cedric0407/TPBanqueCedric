/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mg.cedric.tpbanque.ejb;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import mg.cedric.tpbanque.entities.CompteBancaire;

/**
 *
 * @author CEDRIC
 */
@Singleton
@Startup
public class Init {
    
    @EJB
    private GestionnaireCompte eGestionnaireCompte;
    
    @PostConstruct
    public void init(){
        eGestionnaireCompte.creerCompte(new CompteBancaire("John Lennon", 150000 ));
        eGestionnaireCompte.creerCompte(new CompteBancaire("Paul McCartney", 950000 ));
        eGestionnaireCompte.creerCompte(new CompteBancaire( "Ringo Starr", 20000  ));
        eGestionnaireCompte.creerCompte(new CompteBancaire("Georges Harrisson", 100000));
    }
}
