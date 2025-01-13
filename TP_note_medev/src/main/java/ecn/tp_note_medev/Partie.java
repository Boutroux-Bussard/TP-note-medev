/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecn.tp_note_medev;

import java.util.ArrayList;

/**
 *
 * @author Quent
 */
public class Partie {
    private Joueur joueurBlanc;
    private Joueur joueurNoir;
    private Pion[][] pions;

    public Partie() {
        joueurBlanc = new Joueur(this, false);
        joueurNoir = new Joueur(this, true);
        pions = new Pion[8][8];
    }
    

    public Joueur getJoueurBlanc() {
        return joueurBlanc;
    }

    public void setJoueurBlanc(Joueur joueurBlanc) {
        this.joueurBlanc = joueurBlanc;
    }

    public Joueur getJoueurNoir() {
        return joueurNoir;
    }

    public void setJoueurNoir(Joueur joueurNoir) {
        this.joueurNoir = joueurNoir;
    }

    public Pion[][] getPions() {
        return pions;
    }

    public void setPions(Pion[][] pions) {
        this.pions = pions;
    }
    
}
