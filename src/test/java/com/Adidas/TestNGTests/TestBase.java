package com.Adidas.TestNGTests;

import com.Adidas.utilities.BrowserUtils;
import com.Adidas.utilities.ConfigurationReader;
import com.Adidas.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class TestBase {

    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    protected static ExtentReports report;
    //this class is used to create HTML report file
    protected static ExtentHtmlReporter htmlReporter;
    //this will  define a test, enables adding logs, authors, test steps
    protected static ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest(){
        report= new ExtentReports();

        //create a report path
        String projectPath=System.getProperty("user.dir");
        //we will create a test-output folder and under of this folder 'report.html' file
        String path = projectPath + "/test-output/report.html";
        //if you want to keep previous version of screenshots and report you must name ypu folder as as;
        // String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //String path = projectPath + "/test-output/report" + date+ ".html";

        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);

        //attach the html report to report object
        report.attachReporter(htmlReporter);

        //title in report
        htmlReporter.config().setReportName("Demoblaze Smoke Test");

        //set environment information
        report.setSystemInfo("Environment","QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS",System.getProperty("os.name"));
    }
    @BeforeMethod
    public void setUp(){
        driver = Driver.get();
        actions= new Actions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(ConfigurationReader.get("url"));
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws IOException, InterruptedException {
        //if test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            //record the name of failed test case
            extentLogger.fail(result.getName());

            //take the screenshot and return
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());
            //add you screenshot to your report
            extentLogger.addScreenCaptureFromPath(screenShotPath);
            //capture the exception and put inside the report
            extentLogger.fail(result.getThrowable());

        }

        Thread.sleep(2000);
        Driver.closeDriver();

    }

    @AfterTest
    public void teardown() {
        //this is when the report is actually created
        report.flush();
    }


}
