package com.team4.s4b.service

import com.team4.s4b.domain.*

/**
 * Helper service to manage testing data
 */
class DataService {

    /**
     * Method that will clean out the database and repopulate with default testing data
     * @return
     */
    void populateData() {
        if(BribeContract.list()) BribeContract.list()*.delete()
        if(Bribe.list()) Bribe.list()*.delete()
        if(Recipient.list()) Recipient.list()*.delete()
        if(BribePortfolio.list()) BribePortfolio.list()*.delete()
        if(Opportunity.list()) Opportunity.list()*.delete()
        if(Benefactor.list()) Benefactor.list()*.delete()

        Benefactor b = Benefactor.build(name: 'Demo', password: '1234')
        BribePortfolio bp = BribePortfolio.build(name: 'Special Prizes', benefactor: b)
        Recipient r = Recipient.build(name: 'Kid A', benefactor: b)

        Bribe.build(name: 'Hot Wheels', probability: 10, availableCount: 2, bribePortfolio: bp)
        Bribe.build(name: 'Chocolate', probability: 15, availableCount: 3, bribePortfolio: bp)
        Bribe.build(name: '$100', probability: 1, availableCount: 1, bribePortfolio: bp)
        Bribe.build(name: 'Playtime', probability: 10, availableCount: 4, bribePortfolio: bp)
        Bribe.build(name: 'Movie', probability: 10, availableCount: 2, bribePortfolio: bp)
        Bribe.build(name: 'TV', probability: 10, availableCount: -1, bribePortfolio: bp)
        Bribe.build(name: 'Sleepover', probability: 5, availableCount: 3, bribePortfolio: bp)
        Bribe.build(name: 'Pizza', probability: 2, availableCount: 1, bribePortfolio: bp)

        Opportunity.build(name: "Sit Down", description: "Sit Down Now!", benefactor: b)
        Opportunity.build(name: "Be Quiet", description: "Be Quiet Now!", benefactor: b)
        Opportunity.build(name: "Play Nice", description: "Play Nice Now!", benefactor: b)
        Opportunity.build(name: "Do Homework", description: "Do Homework Now!", benefactor: b)
    }
}
