import com.team4.s4b.domain.Benefactor
import com.team4.s4b.domain.Bribe
import com.team4.s4b.domain.BribePortfolio
import com.team4.s4b.service.ShakeService
import com.team4.s4b.domain.Recipient

class BootStrap {

    def dataService

    def init = { servletContext ->
        dataService.populateData()
    }
    def destroy = {
    }
}
