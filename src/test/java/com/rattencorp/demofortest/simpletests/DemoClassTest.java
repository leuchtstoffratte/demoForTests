/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rattencorp.demofortest.simpletests;

import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class DemoClassTest {
    
    
    
    /**
     * tests {@link DemoClass#addFive(int)}
     * 
     * <pre>
     * demonstrates:
     * <ul>
     *  <li>assertion via {@link org.junit.jupiter.api.Assertions}</li>
     *  <li>basic test structure</li>
     * </ul>
     * </pre>
     */
    @Test
    void addFive_shouldReturn7_whenGiven5() {
        //GIVEN
        final int input = 2;
        final DemoClass testee = new DemoClass();
        
        //WHEN
        final int result = testee.addFive(input);
        
        //THEN
        org.junit.jupiter.api.
                Assertions.assertEquals(            
                        7,                                          //expected value
                        result,                                     //actual result of the method call
                        "should have returned 7, because 2+5=7");   //message in case the test failed
    }

    
    /**
     * test for {@link DemoClass#addFive(int)}
     * 
     * <pre>
     * demonstrates:
     * <ul>
     *  <li>basic test structure</li>
     *  <li>usage of {@link org.assertj.core.api.Assertions}</li>
     * </ul>
     * </pre>
     */
    @Test
    void addFive_shouldReturn0_whenGivenMinus5() {
        //GIVEN
        final int input = -5;
        final DemoClass testee = new DemoClass();
        
        //WHEN
        final int result = testee.addFive(input);
        
        //THEN
        Assertions.assertThat(result)           
                .isEqualTo(0);
    }
}
