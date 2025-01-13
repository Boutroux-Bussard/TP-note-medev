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

    public Pion(Boolean isBlack, Partie partie) {
        this.isBlack = isBlack;
        this.partie = partie;
    }

    public Boolean isBlack() {
        return isBlack;
    }

    public void setIsBlack(Boolean isBlack) {
        this.isBlack = isBlack;
    }

    public Partie getPartie() {
        return partie;
    }
    
    /**
     * retourne le pion sur son autre face
     */
    public void reverse(){
        isBlack=!isBlack;
    }
    
    
    /**
     * Place le pion dans la partie
     * @param x l'indice de la ligne
     * @param y l'indice de la colonne
     */
    public void placer(int x, int y){
        if(x<0 || x>7 || y<0 || y>7){
            System.out.println("sors des limites possibles");
            return;
        }
        partie.getPions()[x][y]=this;
    }
}
