package com.demo;

import biz.trustpay.objects.Request;

import net.rim.device.api.ui.UiApplication;

public class MyApp extends UiApplication{
    /**
     * Entry point for application
     * @param args Command line arguments (not used)
     */ 
    public static void main(String[] args){
    	 MyApp theApp = new MyApp();       
         theApp.enterEventDispatcher();
    }
    
    public MyApp()
    {        
       AppMainScreen ams = new AppMainScreen();
       this.pushScreen(ams);
    }    
}
