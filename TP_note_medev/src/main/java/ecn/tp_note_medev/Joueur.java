/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecn.tp_note_medev;

/**
 *
 * @author Quent
 */
public class Joueur {
    private Partie partie;
    private Boolean isBlack;

    public Joueur(Partie partie, Boolean color) {
        this.partie = partie;
        this.isBlack = color;
    }

    public Partie getPartie() {
        return partie;
    }

    public Boolean getColor() {
        return isBlack;
    }
    
}
