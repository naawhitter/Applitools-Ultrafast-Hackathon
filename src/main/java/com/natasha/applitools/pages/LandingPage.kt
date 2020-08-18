package com.natasha.applitools.pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions

import org.openqa.selenium.support.ui.WebDriverWait





class LandingPage(private val driver: WebDriver, version: String) : BasePage(driver) {
    val wishListButtonLocator = "#A__wishlist__52"
    val filterButtonLocator = "#ti-filter"
    val filterButtonSpanLocator = "#SPAN____208"
    val filterButtonSpanV2Locator = "#SPAN____209"
    val filterSideBarLocator = "#filter_col"
    val cartItemsLocator = "#STRONG____50"
    val gridViewButtonLocator = "#I__tiviewgrid__202"
    val gridViewButtonV2Locator = "#I__tiviewgrid__203"
    val listViewButtonLocator = "#I__tiviewlist__204"
    val listViewButtonV2Locator = "#I__tiviewlist__205"
    val addToFavoritesButtonLocator = "#I__tiheart__225"
    val addToCompareButtonLocator = "#I__ticontrols__229"
    val addToCartButtonLocator = "#I__tishopping__233"
    val quickLinksSectionLocator = "#collapse_1"
    val contactsSectionLocator = "#collapse_3"
    val keepInTouchSectionLocator = "#collapse_4"
    val itemsProductGridLocator = "#product_grid .grid_item"
    private val productGridLocator = "#product_grid"

    // Load hackathon website depending on version
    init {
        when (val version = version.toUpperCase()) {
            "V1", "V2" -> {
                driver.get("https://demo.applitools.com/gridHackathon${version}.html")
            }
            else -> {
                throw RuntimeException("Version $version is not valid. Valid values: v1, v2")
            }
        }
    }

    fun getGridElement(): WebElement {
        return driver.findElement(By.cssSelector(productGridLocator))
    }

    private fun openFilterSideBar(): FilterSideBar {
        val filterSideBar = driver.findElement(By.cssSelector(filterSideBarLocator))
        if (!filterSideBar.isDisplayed) {
            driver.findElement(By.cssSelector(filterButtonLocator)).click()
        }
        return FilterSideBar(driver)
    }

    fun filterByColourBlack() {
        this.openFilterSideBar()
                .setBlackColourFilter(true)
                .clickFilterButton()
    }

    private fun clickItem(itemNum: Int): DetailsPage {
        driver.findElements(By.cssSelector(itemsProductGridLocator))[itemNum].click()
        return DetailsPage(driver)
    }

    fun goToProductPageByColour(itemNum: Int): DetailsPage {
        filterByColourBlack()
        clickItem(itemNum)

        return DetailsPage(driver)
    }

    class FilterSideBar(private var driver: WebDriver) {
        // Colors
        private val filterButtonLocator = "#filterBtn"
        private val colourBlackCheckboxLocator = "#SPAN__checkmark__107"
        private val wait = WebDriverWait(driver, 30)

        fun setBlackColourFilter(isOn: Boolean): FilterSideBar {
            val colourBlackCheckBox = driver.findElement(By.cssSelector(colourBlackCheckboxLocator))
            val isSelected = colourBlackCheckBox.isSelected

            if ((isOn && !isSelected) || (!isOn && isSelected)) {
                wait.until(ExpectedConditions.elementToBeClickable(colourBlackCheckBox)).click()
            }

            return this
        }

        fun clickFilterButton() {
            driver.findElement(By.cssSelector(filterButtonLocator)).click()
        }
    }
}