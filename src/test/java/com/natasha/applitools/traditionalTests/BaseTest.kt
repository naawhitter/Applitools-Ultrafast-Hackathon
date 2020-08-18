package com.natasha.applitools.traditionalTests

import com.natasha.applitools.pages.LandingPage
import com.natasha.applitools.utils.BrowserSettings
import com.natasha.applitools.utils.Browsers
import com.natasha.applitools.utils.Devices
import com.natasha.applitools.utils.Reporter
import io.github.bonigarcia.wdm.WebDriverManager
import org.openqa.selenium.By
import org.openqa.selenium.Dimension
import org.openqa.selenium.NoSuchElementException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.edge.EdgeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.testng.Assert
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Parameters
import java.util.*


open class BaseTest {
    private lateinit var driver: WebDriver
    protected var settings = BrowserSettings()

    protected lateinit var reporter: Reporter
    protected lateinit var landingPage: LandingPage

   @Parameters("browser", "version")
    @BeforeMethod()
    fun openBrowser(browser: String, version: String) {

        when (browser.toLowerCase()) {
            "chrome-desktop" -> {
                setBrowser(Browsers.CHROME)
                setViewport(Devices.LAPTOP)
            }
            "chrome-tablet" -> {
                setBrowser(Browsers.CHROME)
                setViewport(Devices.TABLET)
            }
            "chrome-iphonex" -> {
                val chromeOptions = ChromeOptions()
                val mobileEmulation: HashMap<String, String> = HashMap()
                mobileEmulation["deviceName"] = "iPhone X"
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation)
                setBrowser(Browsers.CHROME, chromeOptions)
                setViewport(Devices.MOBILE)
            }
            "firefox-desktop" -> {
                setBrowser(Browsers.FIREFOX)
                setViewport(Devices.LAPTOP)
            }
            "firefox-tablet" -> {
                setBrowser(Browsers.FIREFOX)
                setViewport(Devices.TABLET)
            }
            "edge-desktop" -> {
                setBrowser(Browsers.EDGE_CHROMIUM)
                setViewport(Devices.LAPTOP)
            }
            "edge-tablet" -> {
                setBrowser(Browsers.EDGE_CHROMIUM)
                setViewport(Devices.TABLET)
            }
            else -> {
                throw IllegalArgumentException("Browser not valid: $browser")
            }
        }

        reporter = Reporter(settings, version)
        landingPage = LandingPage(driver, version)
        landingPage.waitForLoad()
    }

    private fun setBrowser(browser: Browsers, options: ChromeOptions? = null) {
        when (browser) {
            Browsers.CHROME -> {
                WebDriverManager.chromedriver().setup()

                driver = if (options != null) {
                    ChromeDriver(options)
                } else {
                    ChromeDriver()
                }
            }
            Browsers.FIREFOX -> {
                WebDriverManager.firefoxdriver().setup()
                driver = FirefoxDriver()
            }
            Browsers.EDGE_CHROMIUM -> {
                WebDriverManager.edgedriver().setup()
                driver = EdgeDriver()
            }
        }
        settings.name = browser
    }

    private fun setViewport(device: Devices) {
        when (device) {
            Devices.MOBILE -> {
                settings.viewport = Dimension(500, 700)
            }
            Devices.TABLET -> {
                settings.viewport = Dimension(768, 700)
                driver.manage().window().size = settings.viewport
            }
            Devices.LAPTOP -> {
                settings.viewport = Dimension(1200, 700)
                driver.manage().window().size = settings.viewport
            }
        }
        settings.device = device
    }

    fun checkIsDisplayed(locator: String) {
        try {
            val element = driver.findElement(By.cssSelector(locator))

            Assert.assertTrue(reporter.writeReport(locator, element.isDisplayed))
        } catch (e: NoSuchElementException) {
            Assert.assertTrue(reporter.writeReport(locator, false))
        }
    }

    fun checkIsNotDisplayed(locator: String) {
        try {
            val element = driver.findElement(By.cssSelector(locator))

            Assert.assertTrue(reporter.writeReport(locator, !element.isDisplayed))
        } catch (e: NoSuchElementException) {
            Assert.assertTrue(reporter.writeReport(locator, false))
        }
    }

    fun checkNumberOfElementsDisplayed(locator: String, expectedNumItems: Int) {
        try {
            val elements = driver.findElements(By.cssSelector(locator))

            Assert.assertTrue(reporter.writeReport(locator, elements.size == expectedNumItems))
        } catch (e: NoSuchElementException) {
            Assert.assertTrue(reporter.writeReport(locator, false))
        }
    }

    fun checkText(locator: String, expectedText: String) {
        try {
            val element = driver.findElement(By.cssSelector(locator))

            Assert.assertTrue(reporter.writeReport(locator, element.text == expectedText))
        } catch (e: NoSuchElementException) {
            Assert.assertTrue(reporter.writeReport(locator, false))
        }
    }

    fun checkTextStyle(locator: String, expectedCssValue: String) {
        try {
            val textDecoration = driver.findElement(By.cssSelector(locator))
                    .getCssValue("text-decoration")

            Assert.assertTrue(reporter.writeReport(locator, textDecoration.contains(expectedCssValue)))
        } catch (e: NoSuchElementException) {
            Assert.assertTrue(reporter.writeReport(locator, false))
        }
    }

    @AfterMethod(alwaysRun = true)
    fun quitDriver() {
        driver.quit()
    }
}