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
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 *
 * @author Quent
 */
public class PionTest {
    
    public PionTest() {
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
     * Test of isBlack method, of class Pion.
     */
    @Test
    public void testGetCouleur() {
        System.out.println("getCouleur");
        Partie partie= new Partie();
        Boolean expResult = false;
        Pion instance = new Pion(false, partie);
        Boolean result = instance.isBlack();
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsBlack method, of class Pion.
     */
    @Test
    public void testSetCouleur() {
        System.out.println("setCouleur");
        Partie partie= new Partie();
        Boolean expResult = true;
        Pion instance = new Pion(false, partie);
        instance.setIsBlack(true);
        Boolean result = instance.isBlack();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPartie method, of class Pion.
     */
    @Test
    public void testGetPartie() {
        System.out.println("getPartie");
        Partie partie= new Partie();
        Pion instance = new Pion(false, partie);
        Partie result = instance.getPartie();
        assertEquals(partie, result);
    }
    
    /**
     * Test of reverse methode
     */
    @Test
    public void testReverse() {
        System.out.println("Reverse");
        Partie partie = new Partie();
        Pion pionBlanc = new Pion(false, partie);
        pionBlanc.reverse();
        assertEquals(pionBlanc.isBlack(), true);
        Pion pionNoir = new Pion(true, partie);
        pionNoir.reverse();
        assertEquals(pionNoir.isBlack(), false);
    }

    /**
     * Test of placer method, of class Pion.
     */
    @ParameterizedTest
    @CsvSource({"0,0, true", "1,7, true", "2,5, true", "6,3, true", "8,3, false", "6,-1, false"})
    public void testPlacer(int x, int y, Boolean isPossible) {
        System.out.println("placer");
        Partie partie = new Partie();
        Pion instance = new Pion(true, partie);
        instance.placer(x, y);  
        if(isPossible){
           assertEquals(instance, instance.getPartie().getPions()[x][y]); 
        }        
    }
    
    
}
