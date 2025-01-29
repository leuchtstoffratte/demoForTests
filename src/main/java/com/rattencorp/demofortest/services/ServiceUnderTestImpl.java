/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rattencorp.demofortest.services;

import com.rattencorp.demofortest.api.DataSourceService;
import com.rattencorp.demofortest.api.DownStreamService;
import com.rattencorp.demofortest.api.ServiceUnderTest;

/**
 *
 * @author <intentionally left blank>
 */
public class ServiceUnderTestImpl implements ServiceUnderTest{
    
    private final DataSourceService dataSourceService;
    
    private final DownStreamService downStreamService;
    

    public ServiceUnderTestImpl(DataSourceService source, DownStreamService downStream){
        this.dataSourceService = source;
        this.downStreamService = downStream;
    }

    @Override
    public void tokenizeAndCallDownStream() {
        
        dataSourceService.provideStrings().forEach(downStreamService::consumeAString);
        
    }

    
    
    
}
