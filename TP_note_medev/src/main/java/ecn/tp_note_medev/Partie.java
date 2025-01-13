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
        pions[3][3] = new Pion(true, this);
        pions[4][4] = new Pion(true, this);
        pions[3][4] = new Pion(false, this);
        pions[4][3] = new Pion(false, this);
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
      
    /**
    * Affiche les toutes les cases avec un caractere adapte à l'element present sur la case
    */ 
    public void afficher(){
        for (int indiceColonne = 0; indiceColonne < 8; indiceColonne++){
            System.out.println("");
            for (int indiceLigne = 0; indiceLigne < 8; indiceLigne++){
                if (pions[indiceColonne][indiceLigne] == null){
                    System.out.print(" " + "." + " ");
                    continue;
                }
                Pion pionActuel = pions[indiceColonne][indiceLigne];
                if (pionActuel != null){
                    String couleur = "B";
                    if (pionActuel.isBlack()){
                        couleur = "N";
                    }
                    System.out.print(" " + couleur + " ");
                    continue;
                }
                System.out.print(" " + "." + " ");
            }
        }
        System.out.println();
    }
    
    public boolean verifierFinDePartie(){
        return (verifierPartieBloquee() || verifierPlateauPlein());
    }
    
    public boolean verifierPlateauPlein(){
        for (int indiceColonne = 0; indiceColonne < 8; indiceColonne++){
            for (int indiceLigne = 0; indiceLigne < 8; indiceLigne++){
                if (pions[indiceColonne][indiceLigne] == null){
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean verifierPartieBloquee(){
        return (!joueurBlanc.getCanPlay()&&!joueurNoir.getCanPlay());
    }
}
