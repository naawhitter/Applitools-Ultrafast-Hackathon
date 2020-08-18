package com.natasha.applitools.modernTests

import org.testng.annotations.Test

class ModernTestV2 : BaseTest() {

    @Test()
    fun checkLandingPageIsDisplayedCorrectly() {
        eyes.open(driver, appName, "Task 1")

        eyes.checkWindow("Task 1: Landing Page Test")
    }

    @Test()
    fun checkOnlyBlackShoesDisplayedWhenFilterByColourBlack() {
        eyes.open(driver, appName, "Task 2")

        landingPage.filterByColourBlack()

        eyes.checkRegion(landingPage.getGridElement())
        eyes.checkWindow("Task 2: Filter Results Test")
    }

    @Test
    fun checkProductDetails() {
        eyes.open(driver, appName, "Task 3")

        landingPage.goToProductPageByColour(0)

        eyes.checkWindow("Task 3: Product Details Test")
    }
}