package com.natasha.applitools.utils

enum class Devices {
    LAPTOP, TABLET, MOBILE;

    override fun toString(): String {
        return this.name.toLowerCase().replace("_", " ")
    }
}

enum class Browsers {
    CHROME, FIREFOX, EDGE_CHROMIUM;

    override fun toString(): String {
        return this.name.toLowerCase().replace("_", " ")
    }
}

enum class Colours {
    BLACK;

    override fun toString(): String {
        return this.name.toLowerCase().capitalize()
    }
}