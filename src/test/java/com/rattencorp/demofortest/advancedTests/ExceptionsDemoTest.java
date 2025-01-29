/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rattencorp.demofortest.advancedTests;

import java.io.IOException;
import org.junit.jupiter.api.Test;

/**
 *
 * @author <intentionally left blank>
 */
class ExceptionsDemoTest {
    

    @Test
    void testProcessWithIoException_shouldThrowIOEx_whenReceivingInvalidFilename(){
        //GIVEN
        final String doesNotexitst = "*~?ß_not_a_file_name####";
        final ExceptionsDemo testee = new ExceptionsDemo();
        
        //WHEN/THEN
        final Exception result = org.junit.jupiter.api.Assertions
                .assertThrows(IOException.class, 
                        () ->testee.processWithIoException(doesNotexitst),
                        "Should have thrown an IOException");
        
        
        org.junit.jupiter.api.
                Assertions.assertTrue(result.getMessage().contains(doesNotexitst),
                        "Error message should contain filename");
    }
    
    @Test
    void assertJ_testProcessWithIoException_shouldThrowIOEx_whenReceivingInvalidFilename(){
        //GIVEN
        final String doesNotexitst = "*~?ß_not_a_file_name####";
        final ExceptionsDemo testee = new ExceptionsDemo();
        
        //WHEN/THEN
        org.assertj.core.api.Assertions
                .assertThatThrownBy(()-> testee.processWithIoException(doesNotexitst))
                .isInstanceOf(IOException.class);
        
    }
    
}
