/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package pruebasUnitarias;

import java.awt.image.BufferedImage;
import org.junit.jupiter.api.Test;

/**
 *
 * @author RENTCOM SAS
 */
public class NewEmptyJUnitTest {
    
    public NewEmptyJUnitTest() {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    


   @Test
    void testManipulateImage() {
        BufferedImage testImage = new BufferedImage(2500, 600, BufferedImage.TYPE_INT_RGB);

        CodigoPruebasUnitarias.manipulateImage(testImage);


    }
    
}
