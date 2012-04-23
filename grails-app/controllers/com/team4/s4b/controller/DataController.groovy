package com.team4.s4b.controller

/**
 * Web controller to help manage testing data
 */
class DataController {

    def dataService

    /**
     * Method to reset the data on the fly for testing the application
     */
    void reset() {
        dataService.populateData()

        forward(controller: 'shake')
    }
}
