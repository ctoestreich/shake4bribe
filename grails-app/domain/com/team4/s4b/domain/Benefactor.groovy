package com.team4.s4b.domain

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

/**
 * A person who will be offering a bribe.
 */
@ToString
@EqualsAndHashCode
class Benefactor {

    static hasMany = [opportunities: Opportunity, bribePortfolios: BribePortfolio, recipients: Recipient, bribeContracts: BribeContract]

    /** Name of the Benefactor. */
    String name
    /** Password to activate the shake capabilities. */
    String password

    static constraints = {
        name blank: false, nullable: false
        password blank: false, nullable: false, length: 5
    }
}
