/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rattencorp.demofortest.simpletests;

import com.rattencorp.demofortest.simpletests.DemoClass;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

class DemoClassTest {
    /**
     * tests {@link DemoClass#addFive(int)}
     */
    @Test
    void addFive_shouldReturn7_whenGiven5() {
        //GIVEN
        final int input = 2;
        final DemoClass testee = new DemoClass();
        
        //WHEN
        final int result = testee.addFive(input);
        
        //THEN
        org.junit.jupiter.api.Assertions.assertEquals(7, result, "should have returnde 7");
    }


    /**
     * tests {@link DemoClass#addFive(int)}
     */
    @Test
    void addFive_shouldReturn0_whenGivenMinus5() {
        //GIVEN
        final int input = -5;
        final DemoClass testee = new DemoClass();
        
        //WHEN
        final int result = testee.addFive(input);
        
        //THEN
        Assertions.assertThat(result).isEqualTo(0);
    }
}
