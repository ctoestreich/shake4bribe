package com.team4.s4b.service

import com.team4.s4b.exception.BribeShakeException
import com.team4.s4b.domain.*

/**
 * Transactional boundary service for doing shakes and creating contracts in one atomic action.
 */
class ShakeService {

    /**
     * Will return a random bribe from a portfolio taking probability and count into account.
     * <BR>
     * If the usage count is -1 (unlimited) or > 0, then each bribe will exist bribe.probability times in the list.
     * If two bribes with counts != 0 are in the portfolio one with [b1] bribe.probability=3 and the other one with
     * [b2] bribe.probability=1, the map will look like the following: [b1, b1, b1, b2].
     * <BR>
     * A random number between 0 and the list.size() is selected and the list.get(random) bribe is returned.
     * This will also mark the bribe as used by calling useBribe(Bribe) to decrement the usage count (if not unlimited).
     * <br>
     * Will also create a contract for the shake for the given bribe, benefactor and recipient
     *
     * @param bribePortfolio A BribePortfolio on which to run the shake on
     * @param benefactor A Benefactor on which to create a contract for
     * @param recipient A Recipient on which to create a contract for
     * @return A bribe from the portfolio
     * @throws BribeShakeException Exception that could occur if no bribes are in the portfolio
     */
    Bribe shakeForBribe(BribePortfolio bribePortfolio, Benefactor benefactor, Recipient recipient) throws BribeShakeException {
        List<Bribe> listOfBribes = []
        Integer counter = 0

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
            useBribe(bribe)
            createContract(bribe, bribePortfolio, benefactor, recipient)
        } catch(Exception ex) {
            throw new BribeShakeException(ex)
        }

        bribe
    }

    /**
     * Method will create and persist a contract give a bribe and/or portfolio and benefactor and recipient.
     * @param bribe Bribe to create contract against
     * @param bribePortfolio Portfolio to create contract against
     * @param benefactor Benefactor to create contract against
     * @param recipient Recipient to create contract against
     */
    private void createContract(Bribe bribe, BribePortfolio bribePortfolio, Benefactor benefactor, Recipient recipient) {
        new BribeContract(bribePortfolio: bribePortfolio, bribe: bribe, benefactor: benefactor, recipient: recipient).save()
    }

    /**
     * Method that will decrement the availableCount and save the bribe
     * @param bribe Bribe to update adn persist
     */
    private void useBribe(Bribe bribe) {
        if(bribe.availableCount > 0) {
            bribe.availableCount -= 1
        }
        bribe.save(flush: true)
    }
}
