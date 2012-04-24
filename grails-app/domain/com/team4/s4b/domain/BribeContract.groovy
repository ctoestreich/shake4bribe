package com.team4.s4b.domain

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

/**
 * Represents the relationship of the Opportunity and Bribe/BribePortfolio to a Benefactor and Recipient.
 * The bribe portfolio linked to this contract as the bribe may be shaken for on a later date.
 */
@ToString
@EqualsAndHashCode
class BribeContract {

    static belongsTo = [benefactor: Benefactor, recipient: Recipient, bribePortfolio: BribePortfolio]

    /** Boolean indicating whether the bribe has been fulfilled of not for this contract. Defaults to false. */
    Boolean bribeStatus = false
    /** Boolean indicating whether the opportunity has been fulfilled of not for this contract. Defaults to false. */
    Boolean opportunityStatus = false
    /** The opportunity linked to this contract. */
    Opportunity opportunity
    /** The bribe associated with the contract.  This data is embedded into the contract and is a copy of the actual bribe. */
    Bribe bribe

    static embedded = ['bribe']

    static constraints = {
        opportunity nullable: true
        bribePortfolio nullable: false
        bribe nullable: true
        bribeStatus nullable: false
        opportunityStatus nullable: false
    }

    /**
     * Determines whether the contract is completed by combining the bribe and opportunity status fields
     * @return boolean of contract completed
     */
    Boolean getContractStatus() {
        bribeStatus && opportunityStatus
    }
}
