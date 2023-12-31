package com.Adidas.stepdefs;


import com.Adidas.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before()
    public void setUp(){
        System.out.println("\tThis is coming from before hook");
        Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.get().manage().window().maximize();

    }

    @After
    public void tearDown(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","screenshot");
        }

       Driver.closeDriver();
        System.out.println("\tAfter hook close driver");
    }

    @Before("@db")
    public void setUpDB(){
        System.out.println("creating database conneciton...");
      //  DBUtilsLibrary.createConnection();

    }

    @After("@db")
    public void tearDownDb(){
        System.out.println("ending database connection...");
      //  DBUtilsLibrary.destroy();
    }





}
