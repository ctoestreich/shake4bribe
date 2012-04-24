package com.team4.s4b.service

import com.team4.s4b.domain.Bribe

class BribeService {

    /**
     * Method that will decrement the availableCount and save the bribe
     * @param bribe Bribe to update and persist
     * @return Bribe that was updated
     */
    Bribe useBribe(Bribe bribe) {
        if(bribe.availableCount > 0) {
            bribe.availableCount -= 1
        }
        bribe.save()
    }
}
