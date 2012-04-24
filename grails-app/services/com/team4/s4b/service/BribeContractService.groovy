package com.team4.s4b.service

import com.team4.s4b.domain.Bribe
import com.team4.s4b.domain.BribePortfolio
import com.team4.s4b.domain.Benefactor
import com.team4.s4b.domain.Recipient
import com.team4.s4b.domain.Opportunity
import com.team4.s4b.domain.BribeContract

class BribeContractService {

    /**
     * Method will create and persist a contract give a bribe and/or portfolio and benefactor and recipient.
     * @param bribe Bribe to create contract against
     * @param bribePortfolio Portfolio to create contract against
     * @param benefactor Benefactor to create contract against
     * @param recipient Recipient to create contract against
     * @param opportunity Opportunity to create contract against
     */
    BribeContract createContract(Bribe bribe, BribePortfolio bribePortfolio, Benefactor benefactor, Recipient recipient, Opportunity opportunity) {
        new BribeContract(bribePortfolio: bribePortfolio,
                          bribe: bribe,
                          benefactor: benefactor,
                          recipient: recipient,
                          opportunity: opportunity).save()
    }
}
