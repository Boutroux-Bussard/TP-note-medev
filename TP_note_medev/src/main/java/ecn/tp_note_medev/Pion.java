/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecn.tp_note_medev;

/**
 *
 * @author Quent
 */
public class Pion {
    private Boolean couleur;
    private Partie partie;

    public Pion(Boolean couleur, Partie partie) {
        this.couleur = couleur;
        this.partie = partie;
    }

    public Boolean getCouleur() {
        return couleur;
    }

    public void setCouleur(Boolean couleur) {
        this.couleur = couleur;
    }

    public Partie getPartie() {
        return partie;
    }
    
}
