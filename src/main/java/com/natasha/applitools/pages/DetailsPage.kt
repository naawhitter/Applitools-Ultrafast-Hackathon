package com.natasha.applitools.pages

import org.openqa.selenium.WebDriver

class DetailsPage(driver: WebDriver) : BasePage(driver) {
    val itemCodeLocator = "#SMALL____84"
    val sizeDropdownLocator = ".current"
    val newPriceSpanLocator = "#new_price"
    val oldPriceSpanLocator = "#old_price"
}