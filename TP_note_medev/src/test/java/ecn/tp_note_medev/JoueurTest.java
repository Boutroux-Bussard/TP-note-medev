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
    
}
