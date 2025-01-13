/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecn.tp_note_medev;

import java.util.Objects;

/**
 *
 * @author Quent
 */
public class Joueur {
    private Partie partie;
    private Boolean isBlack;
    private Boolean canPlay;

    public Joueur(Partie partie, Boolean color) {
        this.partie = partie;
        this.isBlack = color;
        this.canPlay = true;
    }

    public Partie getPartie() {
        return partie;
    }

    public Boolean getColor() {
        return isBlack;
    }

    public Boolean getCanPlay() {
        return canPlay;
    }
    
    
    /**
     * Fonction recursive qui teste si dans une direction donnée il est possible de retourner des pions
     * @param posX la ligne actuelle
     * @param posY la colonne actuelle
     * @param dirX la direction verticale 0, 1 ou -1
     * @param dirY la direction horyzontale 0, 1 ou -1
     * @return true si on peut retourner qqch,  false sinon
     */
    private Boolean isFlipPossible(int posX,int posY, int dirX, int dirY){
        int newX=posX+dirX;
        int newY=posY+dirY;
        if(newX>0 && newX<8 && newY>0 && newX<8){
            Pion newPion =partie.getPions()[newX][newY];
            if(newPion!=null && Objects.equals(isBlack, newPion.isBlack())){
                return true;
            }else if (newPion !=null){
                return isFlipPossible(newX, newY, dirX, dirY);
            }
        }
        return false;
    }
}
