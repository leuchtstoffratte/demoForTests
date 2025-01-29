/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.rattencorp.demofortest.services;

import com.rattencorp.demofortest.api.DataSourceService;
import com.rattencorp.demofortest.api.DownStreamService;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

/**
 *
 * @author <intentionally left blank>
 */
class ServiceUnderTestImplTest {

    private DataSourceService dataSourceService;
    
    private DownStreamService downStreamService;
    
    private ServiceUnderTestImpl testee;
    
    
    @BeforeEach
    void setUp() {
        dataSourceService = Mockito.mock(DataSourceService.class);
        downStreamService = Mockito.mock(DownStreamService.class);

        testee = new ServiceUnderTestImpl(dataSourceService, downStreamService);
    }
    

    /**
     * Test of {@link ServiceUnderTestImpl#tokenizeAndCallDownStream}
     * 
     * <pre>
     * demonstrates:
     * <ul>
     *  <li>basic configuration of stubs via {@link Mockito#doReturn(java.lang.Object)}-syntax</li>
     *  <li>verification of stub-interaction via {@link Mockito#verify(java.lang.Object, org.mockito.verification.VerificationMode)}
     *         employing generic matchers</li>
     * </ul>
     * </pre>
     */
    @Test
    void testTokenizeAndCallDownStream_shouldCallDownStreamtwice_whenReiveListOfTwoStrings() {
        //GIVEN
        final List<String> strs = List.of("a", "b"); //this is unmodifyable by default

        Mockito.doReturn(strs)                  //expected behaviour
                .when(dataSourceService)        //reference of the configured stub-object
                .provideStrings();              //direct call of the stubbed method
        
        //WHEN
        testee.tokenizeAndCallDownStream();
        
        //THEN
        Mockito.verify(downStreamService, Mockito.times(2))
                .consumeAString(Mockito.anyString());
        
    }
    
    /**
     * Test of {@link ServiceUnderTestImpl#tokenizeAndCallDownStream}
     * 
     * <pre>
     * demonstrates:
     * <ul>
     *  <li>basic configuration of stubs via {@link Mockito#when(java.lang.Object) }-syntax</li>
     *  <li>verification of stub-interaction via {@link Mockito#verify(java.lang.Object)} 
     *      with sepecific elements</li>
     * </ul>
     * </pre>
     */
    @Test
    void testTokenizeAndCallDownStream_shouldCallDownStreamForEachElement_whenReiveListOfTwoStrings() {
        //GIVEN
        final String fristStr = "a";
        final String secnodStr = "b";
        
        final List<String> strs = List.of(fristStr, secnodStr); //this is unmodifyable by default

        Mockito.when(dataSourceService.provideStrings())        //reference to the stubed method
                .thenReturn(strs);                              //expceted behaviour
        
        //WHEN
        testee.tokenizeAndCallDownStream();
        
        //THEN
        Mockito.verify(dataSourceService).provideStrings();     //not required as strict stubbing throws an exception if configured 
                                                                //stubs remain unused
                                                                
        Mockito.verify(downStreamService, Mockito.times(1))     //only one interaction is expected with the argument fristStr
                .consumeAString(Mockito.eq(fristStr));
        Mockito.verify(downStreamService, Mockito.times(1))
                .consumeAString(Mockito.eq(secnodStr));
        
        Mockito.verifyNoMoreInteractions(downStreamService);    //after all interactions are done we expect no further calls to 
                                                                //any(!) method of downStreamService
        
    }

    
    /**
     * Test of {@link ServiceUnderTestImpl#tokenizeAndCallDownStream}
     * 
     * <pre>
     * demonstrates:
     * <ul>
     *  <li>basic configuration of stubs via {@link BDDMockito#given(java.lang.Object) }-syntax</li>
     *  <li>verification of non-interaction via {@link Mockito#verifyNoInteractions(java.lang.Object...) }</li>
     * </ul>
     * </pre>
     */
    @Test
    void testTokenizeAndCallDownStream_shouldCallNeverDownStream_whenReiveEmptyList() {
        //GIVEN
        BDDMockito.given(dataSourceService.provideStrings())    //reference of stubbed method
                .willReturn(Collections.emptyList());           //expected behaviour
        
        //WHEN
        testee.tokenizeAndCallDownStream();
        
        //THEN
        Mockito.verifyNoInteractions(downStreamService);
        
    }

    
}
