/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ecn.tp_note_medev;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Quent
 */
public class PartieTest {
    
    public PartieTest() {
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
     * Test of getJoueurBlanc method, of class Partie.
     */
    @Test
    public void testGetJoueurBlanc() {
        System.out.println("getJoueurBlanc");
        Partie instance = new Partie();
        Joueur result = instance.getJoueurBlanc();
        assertNotNull(result);
    }

    /**
     * Test of setJoueurBlanc method, of class Partie.
     */
    @Test
    public void testSetJoueurBlanc() {
        System.out.println("setJoueurBlanc");
        Partie instance = new Partie();
        Joueur joueurBlanc = new Joueur(instance, false);
        instance.setJoueurBlanc(joueurBlanc);
        Joueur result = instance.getJoueurBlanc();
        assertEquals(result,joueurBlanc);
    }

    /**
     * Test of getJoueurNoir method, of class Partie.
     */
    @Test
    public void testGetJoueurNoir() {
        System.out.println("getJoueurNoir");
        Partie instance = new Partie();
        Joueur result = instance.getJoueurNoir();
        assertNotNull(result);
    }

    /**
     * Test of setJoueurNoir method, of class Partie.
     */
    @Test
    public void testSetJoueurNoir() {
        System.out.println("setJoueurNoir");
        Partie instance = new Partie();
        Joueur joueurNoir = new Joueur(instance, false);
        instance.setJoueurNoir(joueurNoir);
        Joueur result = instance.getJoueurNoir();
        assertEquals(result,joueurNoir);
    }

    /**
     * Test of setPions method, of class Partie.
     */
    @Test
    public void testSetPions() {
        System.out.println("setPions");
        Partie instance = new Partie();
        Pion[][] pions = new Pion[8][8];
        pions[0][0]= new Pion(true, instance);
        instance.setPions(pions);
        Pion[][] result = instance.getPions();
        assertEquals(pions, result);
    }

    /**
     * Test of getPions method, of class Partie.
     */
    @Test
    public void testGetPions() {
        System.out.println("getPions");
        Partie instance = new Partie();
        Pion[][] pions = new Pion[8][8];
        pions[3][3] = new Pion(true, instance);
        pions[4][4] = new Pion(true, instance);
        pions[3][4] = new Pion(false, instance);
        pions[4][3] = new Pion(false, instance);
        instance.setPions(pions);
        Pion[][] result = instance.getPions();
        assertEquals(pions, result);
    }

    /**
     * Test of afficher method, of class Partie.
     */
    @Test
    public void testAfficher() {
        System.out.println("afficher");
        Partie instance = new Partie();
        instance.afficher();
    }

    /**
     * Test of verifierFinDePartie method, of class Partie.
     */
    @Test
    public void testVerifierFinDePartie() {
        System.out.println("verifierFinDePartie");
        Partie instance = new Partie();
        boolean expResult = false;
        boolean result = instance.verifierFinDePartie();
        assertEquals(expResult, result);
        
        Pion[][] pions = new Pion[8][8];
        for (int indiceColonne = 0; indiceColonne < 8; indiceColonne++){
            for (int indiceLigne = 0; indiceLigne < 8; indiceLigne++){
                pions[indiceColonne][indiceLigne] = new Pion(true, instance);
            }
        }
        instance.setPions(pions);
        expResult = true;
        result = instance.verifierFinDePartie();
        assertEquals(expResult, result);
    }
    
}
