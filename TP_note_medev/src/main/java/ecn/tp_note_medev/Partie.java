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
     * Affiche le plateau puis appelle chaque joueur pour qu'il joue. 
     * Verifie a la fin de chaque tour d'un joueur que la partie est finie. 
     */
    public void tourDeJeu(){
        afficher();
        // joueurNoir.jouer();
        verifierFinDePartie();
        afficher();
        // joueurBlanc.jouer();
        verifierFinDePartie();
    }
    
    
      
    /**
    * Affiche toutes les cases avec un B pour les pions blancs et un N pour les pions noirs
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
    
    /**
     * Renvoie true si la partie doit se terminer
     * @return 
     */
    public boolean verifierFinDePartie(){
        return (verifierPartieBloquee() || verifierPlateauPlein());
    }
    
    /**
     * Renvoie true si le plateau n'a plus de place pour des nouveaux pions
     * @return 
     */
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
    
    /**
     * Renvoie true si les deux joueurs ne peuvent plus jouer
     * @return 
     */
    public boolean verifierPartieBloquee(){
        return (!joueurBlanc.getCanPlay()&&!joueurNoir.getCanPlay());
    }
}
