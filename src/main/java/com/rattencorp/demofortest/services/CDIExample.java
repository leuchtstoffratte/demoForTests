/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rattencorp.demofortest.services;

import com.rattencorp.demofortest.api.DataSourceService;
import com.rattencorp.demofortest.api.DownStreamService;
import jakarta.inject.Inject;

/**
 *
 * @author <intentionally left blank>
 */
public class CDIExample {
    
    
    @Inject
    private DataSourceService dataSourceService;

    @Inject
    private DownStreamService downStreamService;

    
    
    public void tokenizeAndCallDownStream() {
        
        dataSourceService.provideStrings().forEach(downStreamService::consumeAString);
        
    }


    
}
