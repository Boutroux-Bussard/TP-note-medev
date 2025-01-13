/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ecn.tp_note_medev;

/**
 *
 * @author remib
 */
public class TP_note_medev {

    public static void main(String[] args) {
        Partie partie = new Partie();
        boolean finDePartie = false;
        while(!finDePartie){
            finDePartie = partie.tourDeJeu();
        }
        partie.afficherResultat();
    }
}
