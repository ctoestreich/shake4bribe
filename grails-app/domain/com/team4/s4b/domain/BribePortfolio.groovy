package com.team4.s4b.domain

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

/**
 * Represents a collection of bribes that are grouped together into come context.
 */
@EqualsAndHashCode
class BribePortfolio {

    static hasMany = [bribes: Bribe, bribeContracts: BribeContract]
    static belongsTo = [benefactor: Benefactor]

    /** Name of the BribePortfolio */
    String name

    static constraints = {
        name blank:  false, nullable: false
    }

    @Override
    public String toString() {
        name
    }
}
