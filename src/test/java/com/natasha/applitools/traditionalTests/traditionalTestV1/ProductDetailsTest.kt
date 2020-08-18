package com.natasha.applitools.traditionalTests.traditionalTestV1

import com.natasha.applitools.traditionalTests.BaseTest
import org.testng.annotations.Test

class ProductDetailsTest : BaseTest() {

    @Test
    fun checkItemCodeIsDisplayed() {
        reporter.setTestDetails(3, "Item code is displayed")

        val detailsPage = landingPage.goToProductPageByColour(0)

        checkIsDisplayed(detailsPage.itemCodeLocator)
    }

    @Test
    fun checkSizeSmallValueEqualsSmallS() {
        reporter.setTestDetails(3, "Small size value equals 'Small (S)'")

        val detailsPage = landingPage.goToProductPageByColour(0)

        checkText(detailsPage.sizeDropdownLocator, "Small (S)")
    }

    @Test
    fun checkNewPriceHasDecimals() {
        reporter.setTestDetails(3, "New price value equals $33.00")

        val detailsPage = landingPage.goToProductPageByColour(0)

        checkText(detailsPage.newPriceSpanLocator, "$33.00")
    }

    @Test
    fun checkOldPriceHasCssValueLineThrough() {
        reporter.setTestDetails(3, "Old price has text decoration value 'line-Through'")

        val detailsPage = landingPage.goToProductPageByColour(0)

        checkTextStyle(detailsPage.oldPriceSpanLocator, "line-through")
    }
}