package com.team4.s4b.service

import com.team4.s4b.exception.BribeShakeException
import com.team4.s4b.domain.*

/**
 * Transactional boundary service for doing shakes and creating contracts in one atomic action.
 */
class ShakeService {

    def bribeContractService
    def bribeService

    /**
     * Will return a random bribe from a portfolio taking probability and count into account.
     * <BR><BR>
     * If the usage count is -1 (unlimited) or > 0, then each bribe will exist bribe.probability times in the list.
     * If two bribes with counts != 0 are in the portfolio one with [b1] bribe.probability=3 and the other one with
     * [b2] bribe.probability=1, the list will look like the following: [b1, b1, b1, b2].
     * <BR><BR>
     * A random number between 0 and the list.size() is selected and the list.get(random) bribe is returned.
     * This will also mark the bribe as used by calling useBribe(Bribe) to decrement the usage count (if not unlimited).
     * <br><BR>
     * Will also create a contract for the shake for the given bribe, benefactor and recipient
     *
     * @param bribePortfolio A BribePortfolio on which to run the shake on
     * @param benefactor A Benefactor on which to create a contract for
     * @param recipient A Recipient on which to create a contract for
     * @param opportunity The opportunity to perform on which to create a contract for
     * @return A bribe from the portfolio
     * @throws BribeShakeException Exception that could occur if no bribes are in the portfolio
     */
    Bribe shakeForBribe(BribePortfolio bribePortfolio, Benefactor benefactor, Recipient recipient, Opportunity opportunity) throws BribeShakeException {
        List<Bribe> listOfBribes = []

        bribePortfolio.bribes.each { Bribe bribe ->
            if(bribe.availableCount != 0) {
                bribe.probability.times {
                    listOfBribes << bribe
                }
            }
        }
        def bribe = listOfBribes.get(new Random().nextInt(listOfBribes.size()))
        if(!bribe) {
            throw new BribeShakeException("Could not load bribe from bribe list")
        }

        try {
            bribeService.useBribe(bribe)
            bribeContractService.createContract(bribe, bribePortfolio, benefactor, recipient, opportunity)
        } catch(Exception ex) {
            throw new BribeShakeException(ex)
        }

        bribe
    }
}
