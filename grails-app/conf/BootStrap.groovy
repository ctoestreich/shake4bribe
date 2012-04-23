import com.team4.s4b.domain.Benefactor
import com.team4.s4b.domain.Bribe
import com.team4.s4b.domain.BribePortfolio
import com.team4.s4b.service.ShakeService
import com.team4.s4b.domain.Recipient

class BootStrap {

    def init = { servletContext ->
        populateData()
    }
    def destroy = {
    }

    private populateData(){


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
    }
}
