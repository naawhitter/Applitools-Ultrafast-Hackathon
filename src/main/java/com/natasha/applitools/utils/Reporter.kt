package com.natasha.applitools.utils

import java.io.BufferedWriter
import java.io.FileWriter

data class Reporter(private var settings: BrowserSettings, private val version: String) {
    private var taskId: Int = 0
    private lateinit var testName: String

    fun setTestDetails(taskId: Int, testName: String) {
        this.taskId = taskId
        this.testName = testName
    }

    /**
     * A Helper to print the test result in the following format:
     * Task: <Task Number>, Test Name: <Test Name>, DOM Id:: <id>, Browser: <Browser>, Viewport: <Width x Height>, Device<Device type>, Status: <Pass | Fail>
     *
     * Example: Task: 1, Test Name: Search field is displayed, DOM Id: DIV__customsear__41, Browser: Chrome, Viewport: 1200 x 700, Device: Laptop, Status: Pass
     *
     * @param task                    int - 1, 2 or 3
     * @param testName               string - Something meaningful. E.g. 1.1 Search field is displayed
     * @param domId                   string - DOM ID of the element
     * @param comparisonResult        boolean - The result of comparing the "Expected" value and the "Actual" value.
     * @return              boolean - returns the same comparison result back so that it can be used for further Assertions in the test code.
    </Pass></Device></Width></Browser></id></Test></Task> */
    fun writeReport(domId: String, comparisonResult: Boolean): Boolean {
        try {
            val viewport = "${settings.viewport.width} x ${settings.viewport.height}";

            BufferedWriter(FileWriter("Traditional-${version.toUpperCase()}-TestResults.txt", true)).use { writer ->
                writer.write("Task: $taskId, Test Name: $testName, DOM Id: $domId, Browser: ${settings.name}, " +
                        "Viewport: $viewport, Device: ${settings.device}, Status: ${if (comparisonResult) "Pass" else "Fail"}")
                writer.newLine()
            }
        } catch (e: Exception) {
            println("Error writing to report file")
            e.printStackTrace()
        }
        //returns the result so that it can be used for further Assertions in the test code.
        return comparisonResult
    }
}