/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.rattencorp.demofortest.advancedTests;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author <intentionally left blank>
 */
public class ExceptionsDemo {
    
    
    /**
     * 
     * @param filename
     * @throws IOException 
     */
    public void processWithIoException(String filename) throws IOException{
        if(!filename.startsWith("/")){
            throw new IOException("can't process %s".format(filename));
        }
    }

}
