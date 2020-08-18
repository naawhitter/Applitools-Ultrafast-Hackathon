package com.natasha.applitools.traditionalTests.traditionalTestV1

import com.natasha.applitools.traditionalTests.BaseTest
import org.testng.annotations.Test

class ShoppingExperienceTest : BaseTest() {

    @Test
    fun checkTwoBlackShoesAreDisplayedWhenFilteredByColourBlack() {
        reporter.setTestDetails(2, "2 black shoes are displayed when filtered by colour black")

        landingPage.filterByColourBlack()

        checkNumberOfElementsDisplayed(landingPage.itemsProductGridLocator, 2)
    }
}