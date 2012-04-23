package com.team4.s4b.controller

import com.team4.s4b.domain.BribePortfolio
import com.team4.s4b.domain.Benefactor
import com.team4.s4b.domain.Recipient

class ShakeController {

    def shakeService

    def index(){
        Benefactor benefactor = Benefactor.list().get(0)
        render view: 'index', model:  [benefactor: benefactor]
    }

    def shake() {
        render shakeService.shakeForBribe(BribePortfolio.get(params.bribeportfolio.id), Benefactor.get(params.benefactor.id), Recipient.get(params.recipient.id)).toString()
    }
}
