package com.team4.s4b.controller

import com.team4.s4b.domain.BribePortfolio
import com.team4.s4b.domain.Benefactor
import com.team4.s4b.domain.Recipient

/**
 * Main web controller for doing shakes
 */
class ShakeController {

    def shakeService

    /**
     * Web method to invoke to render the main shake page
     * @return
     */
    def index(){
        Benefactor benefactor = Benefactor.list().get(0)
        render view: 'index', model:  [benefactor: benefactor]
    }

    /**
     * Ajax method to invoke the shake service to perform the rolling and contract creation.
     * @return Bribe object
     */
    def shake() {
        render shakeService.shakeForBribe(BribePortfolio.get(params.bribeportfolio.id), Benefactor.get(params.benefactor.id), Recipient.get(params.recipient.id)).toString()
    }
}
