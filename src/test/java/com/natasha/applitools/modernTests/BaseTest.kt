package com.natasha.applitools.modernTests

import com.applitools.eyes.BatchInfo
import com.applitools.eyes.EyesRunner
import com.applitools.eyes.RectangleSize
import com.applitools.eyes.TestResultContainer
import com.applitools.eyes.selenium.BrowserType
import com.applitools.eyes.selenium.Configuration
import com.applitools.eyes.selenium.Eyes
import com.applitools.eyes.visualgrid.model.DeviceName
import com.applitools.eyes.visualgrid.model.ScreenOrientation
import com.applitools.eyes.visualgrid.services.VisualGridRunner
import com.natasha.applitools.pages.LandingPage
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.testng.ITestContext
import org.testng.ITestResult
import org.testng.annotations.*
import java.util.concurrent.TimeUnit


open class BaseTest {
    lateinit var driver: WebDriver

    private var runner: EyesRunner? = null
    lateinit var eyes: Eyes
    private lateinit var suiteConfig: Configuration
    var appName: String = "AppliFashion"

    lateinit var landingPage: LandingPage

    @Parameters("apiKey")
    @BeforeSuite
    open fun beforeTestSuite(apiKey: String) {

        runner = VisualGridRunner(10)

        suiteConfig = Configuration()
        suiteConfig // Visual Grid configurations
                .addBrowser(800, 600, BrowserType.CHROME)
                .addBrowser(700, 500, BrowserType.FIREFOX)
                .addBrowser(1600, 1200, BrowserType.IE_11)
                .addBrowser(1024, 768, BrowserType.EDGE_CHROMIUM)
                .addBrowser(800, 600, BrowserType.SAFARI)
                .addDeviceEmulation(DeviceName.iPhone_X, ScreenOrientation.PORTRAIT)
                .addDeviceEmulation(DeviceName.Pixel_2, ScreenOrientation.PORTRAIT)
                .setViewportSize(RectangleSize(800, 600)) // Test suite configurations
                .setApiKey(apiKey)
                .setBatch(BatchInfo("UFG Hackathon"))
    }

    @Parameters("version")
    @BeforeMethod
    fun launchBrowser(version: String) {
        eyes = Eyes(runner)
        eyes.configuration = suiteConfig

        WebDriverManager.chromedriver().setup()
        driver = ChromeDriver()
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS)

        landingPage = LandingPage(driver, version)
        landingPage.waitForLoad()
    }

    @AfterMethod(alwaysRun = true)
    fun quitDriver(result: ITestResult) {

        val testFailed = result.status == ITestResult.FAILURE

        if (!testFailed) {
            eyes.closeAsync()
        } else {
            eyes.abortAsync()
        }
        driver.quit()
    }

    @AfterSuite
    open fun afterTestSuite(testContext: ITestContext?) {
        //Wait until the test results are available and retrieve them
        val allTestResults = runner!!.getAllTestResults(false)
        for (result in allTestResults) {
            handleTestResults(result)
        }
    }

    open fun handleTestResults(summary: TestResultContainer) {
        val ex = summary.exception
        if (ex != null) {
            System.out.printf("System error occured while checking target.\n")
        }
        val result = summary.testResults
        if (result == null) {
            System.out.printf("No test results information available\n")
        } else {
            System.out.printf("URL = %s, AppName = %s, testname = %s, Browser = %s,OS = %s, viewport = %dx%d, matched = %d,mismatched = %d, missing = %d,aborted = %s\n",
                    result.url,
                    result.appName,
                    result.name,
                    result.hostApp,
                    result.hostOS,
                    result.hostDisplaySize.width,
                    result.hostDisplaySize.height,
                    result.matches,
                    result.mismatches,
                    result.missing,
                    if (result.isAborted) "aborted" else "no")
        }
    }
}