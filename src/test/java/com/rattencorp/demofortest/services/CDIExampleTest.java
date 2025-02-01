/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rattencorp.demofortest.services;

import com.rattencorp.demofortest.api.DataSourceService;
import com.rattencorp.demofortest.api.DownStreamService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author <intentionally left blank>
 */
@ExtendWith(MockitoExtension.class)         //provides (among other things) CDI-capability for unittests
class CDIExampleTest {

    @Mock                                   //creates a stub for this type
    private DataSourceService dataSourceService;
    
    @Mock
    private DownStreamService downStreamService;
    
    @InjectMocks                            //injects stubs in this instance. No longer useful with constructor/setter-injection
    private CDIExample testee;

    

    /**
     * Test of {@link CDIExample#tokenizeAndCallDownStream()}
     * 
     * <pre>
     * demonstrates:
     * <ul>
     *  <li>advanced configuration of stubs via {@link Mockito#when(java.lang.Object) }-syntax
     *      with differing returns for different calls</li>
     *  <li>asserting Exceptions are thrown</li>
     * </ul>
     * </pre>
     */
    @Test
    void testTokenizeAndCallDownStream() {
        
        //GIVEN
        final List<String> input = List.of("foo", "bar");
        
        Mockito.when(dataSourceService.provideStrings())
                .thenReturn(input)                              //configure behaviour for first call
                .thenThrow(new RuntimeException("oh, no"));     //last configuration is used for all subsequent calls
        
        //WHEN/THEN
        testee.tokenizeAndCallDownStream();
        
        Assertions.assertThrows(RuntimeException.class, 
                () -> testee.tokenizeAndCallDownStream(),       //trigger second call
                "second call should throw runtime exception, because i say so");
        
    }
    
}
