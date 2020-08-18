package com.natasha.applitools.traditionalTests.traditionalTestV2

import com.natasha.applitools.traditionalTests.BaseTest
import org.testng.annotations.Test

class CrossDeviceElementTest : BaseTest() {

    @Test()
    fun checkMainMenuIsDisplayedOnDesktop() {
        reporter.setTestDetails(1, "Main menu is displayed on desktop")

        val mainMenuDivLocator = landingPage.mainMenuDivLocator

        if (settings.viewport.width > 991) {
            checkIsDisplayed(mainMenuDivLocator)
        } else {
            checkIsNotDisplayed(mainMenuDivLocator)
        }
    }

    @Test
    fun checkSearchBarIsDisplayedOnDesktopAndTablet() {
        reporter.setTestDetails(1, "Search bar is displayed on desktop and tablet")

        val searchBoxDivLocator = landingPage.searchBoxInputLocator

        if (settings.viewport.width > 767) {
            checkIsDisplayed(searchBoxDivLocator)
        } else {
            checkIsNotDisplayed(searchBoxDivLocator)
        }
    }

    @Test
    fun checkSearchButtonIsDisplayedOnTabletAndMobile() {
        reporter.setTestDetails(1, "Search button is displayed on tablet and mobile")

        val searchIconLocator = landingPage.searchBoxLinkLocator

        if (settings.viewport.width > 767) {
            checkIsNotDisplayed(searchIconLocator)
        } else {
            checkIsDisplayed(searchIconLocator)
        }
    }

    @Test
    fun checkWishlistButtonIsDisplayedOnDesktop() {
        reporter.setTestDetails(1, "WishList button is displayed on desktop")

        val wishListButtonLocator = landingPage.wishListButtonLocator

        if (settings.viewport.width > 991) {
            checkIsDisplayed(wishListButtonLocator)
        } else {
            checkIsNotDisplayed(wishListButtonLocator)
        }
    }

    @Test
    fun checkCartDisplaysTwoItemsOnlyOnMobileScreens() {
        reporter.setTestDetails(1, "Cart displays two items on desktop and tablet")

        val cartItemsLocator = landingPage.cartItemsLocator

        if (settings.viewport.width > 767) {
            checkIsDisplayed(cartItemsLocator)
        } else {
            checkIsDisplayed(cartItemsLocator)
        }
    }

    @Test
    fun checkFilterButtonIsDisplayedOnTabletAndMobile() {
        reporter.setTestDetails(1, "Filter button is displayed on tablet and mobile")

        val filterButtonDivLocator = landingPage.filterButtonLocator

        if (settings.viewport.width > 991) {
            checkIsNotDisplayed(filterButtonDivLocator)
        } else {
            checkIsDisplayed(filterButtonDivLocator)
        }
    }

    @Test
    fun checkFilterButtonLabelIsDisplayedOnTablet() {
        reporter.setTestDetails(1, "Filter button label is displayed on tablet")

        val filterButtonSpanLocator = landingPage.filterButtonSpanV2Locator

        if (settings.viewport.width > 991 || settings.viewport.width < 768) {
            checkIsNotDisplayed(filterButtonSpanLocator)
        } else {
            checkIsDisplayed(filterButtonSpanLocator)
        }
    }

    @Test
    fun checkFilterSideBarIsDisplayedOnDesktop() {
        reporter.setTestDetails(1, "Filter sidebar is displayed on desktop")

        val filterSideBarLocator = landingPage.filterSideBarLocator

        if (settings.viewport.width > 991) {
            checkIsDisplayed(filterSideBarLocator)
        } else {
            checkIsNotDisplayed(filterSideBarLocator)
        }
    }

    @Test
    fun checkViewByGridButtonIsDisplayedOnDesktop() {
        reporter.setTestDetails(1, "View by grid button is displayed only on desktop")

        val gridViewButtonLocator = landingPage.gridViewButtonV2Locator

        if (settings.viewport.width > 991) {
            checkIsDisplayed(gridViewButtonLocator)
        } else {
            checkIsNotDisplayed(gridViewButtonLocator)
        }
    }

    @Test
    fun checkViewByListButtonIsDisplayedOnDesktop() {
        reporter.setTestDetails(1, "View by list button is displayed on desktop")

        val listViewButtonLocator = landingPage.listViewButtonV2Locator

        if (settings.viewport.width > 991) {
            checkIsDisplayed(listViewButtonLocator)
        } else {
            checkIsNotDisplayed(listViewButtonLocator)
        }
    }

    @Test
    fun checkAddToFavoriteButtonIsDisplayedOnTabletAndMobile() {
        reporter.setTestDetails(1, "Add to favorite button is displayed on tablet and mobile")

        val addToFavoritesButtonLocator = landingPage.addToFavoritesButtonLocator

        if (settings.viewport.width > 991) {
            checkIsNotDisplayed(addToFavoritesButtonLocator)
        } else {
            checkIsDisplayed(addToFavoritesButtonLocator)
        }
    }

    @Test
    fun checkAddToCompareButtonIsDisplayedOnTabletAndMobile() {
        reporter.setTestDetails(1, "Add to compare button is displayed on tablet and mobile")

        val addToCompareButtonLocator = landingPage.addToCompareButtonLocator

        if (settings.viewport.width > 991) {
            checkIsNotDisplayed(addToCompareButtonLocator)
        } else {
            checkIsDisplayed(addToCompareButtonLocator)
        }
    }

    @Test
    fun checkAddToCartButtonIsDisplayedOnTabletAndMobile() {
        reporter.setTestDetails(1, "Add to cart button is displayed on tablet and mobile")

        val addToCartButtonLocator = landingPage.addToCartButtonLocator

        if (settings.viewport.width > 991) {
            checkIsNotDisplayed(addToCartButtonLocator)
        } else {
            checkIsDisplayed(addToCartButtonLocator)
        }
    }

    @Test
    fun checkQuickLinksSectionIsMinimisedOnMobileScreen() {
        reporter.setTestDetails(1, "Quick links section is minimised on mobile")

        val quickLinksSectionLocator = landingPage.quickLinksSectionLocator

        if (settings.viewport.width > 767) {
            checkIsDisplayed(quickLinksSectionLocator)
        } else {
            checkIsDisplayed(quickLinksSectionLocator)
        }
    }

    @Test
    fun checkContactsSectionIsMinimisedOnMobile() {
        reporter.setTestDetails(1, "Contacts section is minimised on mobile")

        val contactsSectionLocator = landingPage.contactsSectionLocator

        if (settings.viewport.width > 767) {
            checkIsDisplayed(contactsSectionLocator)
        } else {
            checkIsNotDisplayed(contactsSectionLocator)
        }
    }

    @Test
    fun checkKeepInTouchSectionIsMinimisedOnMobile() {
        reporter.setTestDetails(1, "keep in touch section is minimised on mobile")

        val keepInTouchSectionLocator = landingPage.keepInTouchSectionLocator

        if (settings.viewport.width > 767) {
            checkIsDisplayed(keepInTouchSectionLocator)
        } else {
            checkIsNotDisplayed(keepInTouchSectionLocator)
        }
    }
}