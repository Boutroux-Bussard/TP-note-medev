/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ecn.tp_note_medev;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Quent
 */
public class JoueurTest {
    
    public JoueurTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getPartie method, of class Joueur.
     */
    @Test
    public void testGetPartie() {
        System.out.println("getPartie");
        Partie expResult = new Partie();
        Joueur instance = new Joueur(expResult, false);
        Partie result = instance.getPartie();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Joueur.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        Partie expResult = new Partie();
        Joueur instance = new Joueur(expResult, false);
        Boolean result = instance.getColor();
        assertEquals(false, result);
    }

    /**
     * Test of getCanPlay method, of class Joueur.
     */
    @Test
    public void testGetCanPlay() {
        System.out.println("getCanPlay");
        Partie partie = new Partie();
        Joueur instance = new Joueur(partie, false);
        Boolean expResult = true;
        Boolean result = instance.getCanPlay();
        assertEquals(expResult, result);
    }

    /**
     * Test of isFlipPossible method, of class Joueur.
     */
    @Test
    @ParameterizedTest
    @CsvSource({"false,0,0,1,1,false", "false,0,0,-1,-1,false", "false,3,2,-1,-1,false", "false,3,2,0,1,false","true,3,2,0,1,true","true,2,2,1,1,true"})
    public void testIsFlipPossible(Boolean isBlack, int posX,int posY, int dirX, int dirY, Boolean expResult) {
        System.out.println("isFlipPossible");
        Partie partie = new Partie();
        Pion pionNoir = new Pion(true, partie);
        pionNoir.placer(5, 5);
        Joueur instance = new Joueur(partie, isBlack);
        Boolean result = instance.isFlipPossible(posX, posY, dirX, dirY);
        assertEquals(expResult, result);
    }

    /**
     * Test of detecterCasesPossibles method, of class Joueur.
     */
    @Test
    public void testDetecterCasesPossibles() {
        System.out.println("detecterCasePossibles");
        Partie partie= new Partie();
        Joueur instance = new Joueur(partie, true);
        ArrayList result = instance.detecterCasesPossibles();
        assertEquals(result.size(), 4);
    }

    /**
     * Test of detecterCase method, of class Joueur.
     */
    @Test
    @ParameterizedTest
    @CsvSource({"false,0,0,false","false,3,3,false","false,2,2,false","false,3,2,false","true,3,2,true"})
    public void testDetecterCase(Boolean expResult, int x, int y,Boolean isBlack) {
        System.out.println("detecterCase");
        Partie partie= new Partie();
        Joueur instance = new Joueur(partie, isBlack);
        Boolean result = instance.detecterCase(x, y);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testFlipper(){
        System.out.println("flipper");
        Partie partie = new Partie();
        Joueur joueurUn = new Joueur(partie, true);
        joueurUn.flipper(3,2);
        assertEquals(partie.getPions()[3][3].isBlack(), true);
        assertEquals(partie.getPions()[3][2].isBlack(),true);
    }
}
