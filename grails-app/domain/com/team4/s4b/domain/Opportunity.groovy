package com.team4.s4b.domain

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

/**
 * Represents the action that needs to be performed to receive a bribe.
 */
@EqualsAndHashCode
class Opportunity {

    static belongsTo = [benefactor: Benefactor]
    static hasMany = [bribeContracts: BribeContract]

    /** Name of the Opportunity. */
    String name
    /** Description of the Opportunity. */
    String description

    static constraints = {
        name blank: false, nullable: false
        description blank: false, nullable: false
    }

    @Override
    public String toString() {
        name
    }
}
