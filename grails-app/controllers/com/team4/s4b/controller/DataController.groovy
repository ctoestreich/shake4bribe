package com.team4.s4b.controller

class DataController {

    def dataService

    def reset() {
        dataService.populateData()

        forward(controller: 'shake')
    }
}
