/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ecn.tp_note_medev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

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
     * teste toutes les cases pour savoir si elles sont jouables
     * @return liste des coordonnees
     */
    public ArrayList<int[]> detecterCasesPossibles(){
        ArrayList<int[]> coordo = new ArrayList<int[]>();
        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                if(detecterCase(x,y)){
                    int[] coordonee = new int[2];
                    coordonee[0]=x;
                    coordonee[1]=y;
                    coordo.add(coordonee);
                }
            }
        }
        return coordo;
    }
    
    /**
     * Teste si une case specifique est jouable
     * @param x position verticale de la case
     * @param y position horyzontale de la case
     * @return true si la case est jouable
     */
    protected Boolean detecterCase(int x,int y){
        if(partie.getPions()[x][y]!=null){
            return false;
        }
        
        for(int dirX=-1; dirX<2; dirX++){
            for (int dirY=-1; dirY<2; dirY++){
                if((dirX!=0 || dirY!=0) && isFlipPossible(x, y, dirX, dirY)){
                    return true;
                }
            }
        }
        return false;
    }
    
    
    /**
     * Fonction recursive qui teste si dans une direction donnée il est possible de retourner des pions
     * @param posX la ligne actuelle
     * @param posY la colonne actuelle
     * @param dirX la direction verticale 0, 1 ou -1
     * @param dirY la direction horyzontale 0, 1 ou -1
     * @return true si on peut retourner qqch,  false sinon
     */
    protected Boolean isFlipPossible(int posX,int posY, int dirX, int dirY){
        int newX=posX+dirX;
        int newY=posY+dirY;
        if(newX>0 && newX<8 && newY>0 && newY<8){
            Pion newPion = partie.getPions()[newX][newY];
            Pion oldPion = partie.getPions()[posX][posY];
            if(newPion!=null && isBlack==newPion.isBlack() && oldPion!=null && isBlack!=oldPion.isBlack()){
                return true;
            }else if (newPion !=null && isBlack!=newPion.isBlack()){
                return isFlipPossible(newX, newY, dirX, dirY);
            }
        }
        return false;
    }
    
    /**
     * gere le tour d'un joueur (choix de la case et retournage des jetons)
     */
    public void jouer(){
        ArrayList<int[]> cases = detecterCasesPossibles();
        if(cases.isEmpty()){
            canPlay=false;
            return;
        }
        int[] choix = declencherChoixCase(cases);
        
        Pion pionJoue= new Pion(isBlack, partie);
        pionJoue.placer(choix[0], choix[1]);
        
        flipper(choix[0],choix[1]);
    }
    
    /**
     * le joueur choisi son coup
     * @param cases les cases possibles
     * @return le choix du joueur
     */
    private int[] declencherChoixCase(ArrayList<int[]> cases){
        int[] choix = new int[2];
        choix[0]=0;
        choix[1]=0;
        ArrayList<String> colonnes = new ArrayList<String>(Arrays.asList("a", "b","c","d","e","f","g","h"));
        
        System.out.println("Où voulez vous placer un pion (choisissez parmi la liste suivante) ?");
        // liste de positions possibles
        for (int i=0; i<cases.size(); i++){
            System.out.println(colonnes.get(cases.get(i)[0]) + cases.get(i)[1]);
        }
        Scanner lectureClavier = new Scanner(System.in);
        boolean choixValable = false;
        while (!choixValable){
            
            String choixJoueur =lectureClavier.nextLine();
            choixJoueur = choixJoueur.toUpperCase();
            
            char columnChar = choixJoueur.charAt(0);
            try{
                choix[0] = colonnes.indexOf(columnChar);
            }
            catch(Exception e){
                choixValable = false;
            }
            char lineChar = choixJoueur.charAt(1);
            try{
                choix[1] = Integer.parseInt(String.valueOf(lineChar));
            }
            catch(Exception e){
                choixValable = false;
            }
        }
        return choix;
    }
    
    /**
     * Flippe toutes les cases concernees apres un coup
     * @param x 
     * @param y 
     */
    protected void flipper(int x, int y){
        for(int dirX=-1; dirX<2; dirX++){
            for (int dirY=-1; dirY<2; dirY++){
                if((dirX!=0 || dirY!=0)){
                    flipperDirection(x, y, dirX, dirY);
                }
            }
        }
    }
    
    /**
     * Flippe toutes les cases dans une directions donnees si besoin
     * @param x
     * @param y
     * @param dirX
     * @param dirY
     * @return 
     */
    private Boolean flipperDirection(int x,int y, int dirX, int dirY){
        int newX=x+dirX;
        int newY=y+dirY;
        
        if(newX<0 && newX>=8 && newY<0 && newY>=8){
            return false;
        }
        
        Pion newPion = partie.getPions()[newX][newY];
        Pion oldPion = partie.getPions()[x][y];
        
        if(newPion!=null && isBlack==newPion.isBlack() && oldPion!=null && isBlack!=oldPion.isBlack()){
            return true;
        }else if (newPion !=null && isBlack!=newPion.isBlack()){
            Boolean estFlippe = isFlipPossible(newX, newY, dirX, dirY);
            if(estFlippe){
                newPion.reverse();
            }
            return estFlippe;
        }
        
        return false;
    }
}
