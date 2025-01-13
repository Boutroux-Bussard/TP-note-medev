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
    private Boolean isBlack;
    private Partie partie;

    public Pion(Boolean couleur, Partie partie) {
        this.isBlack = couleur;
        this.partie = partie;
    }

    public Boolean getCouleur() {
        return isBlack;
    }

    public void setCouleur(Boolean couleur) {
        this.isBlack = couleur;
    }

    public Partie getPartie() {
        return partie;
    }
    
}
