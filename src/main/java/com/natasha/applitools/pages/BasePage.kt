package com.natasha.applitools.pages

import org.openqa.selenium.By
import org.openqa.selenium.JavascriptExecutor
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedCondition
import org.openqa.selenium.support.ui.WebDriverWait

open class BasePage(driver: WebDriver) {
    val mainMenuDivLocator = "#DIV__mainmenu__15"
    val searchBoxInputLocator = "#DIV__customsear__41"
    val searchBoxLinkLocator = "#A__btnsearchm__59"

    private val wait = WebDriverWait(driver, 30)

    fun waitForLoad() {
        val pageLoadCondition: ExpectedCondition<Boolean> = ExpectedCondition {
            (it as JavascriptExecutor?)!!.executeScript("return document.readyState") == "complete"
        }
        wait.until(pageLoadCondition)
    }
}