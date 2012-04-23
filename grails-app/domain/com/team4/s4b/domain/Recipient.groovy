package com.team4.s4b.domain

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

/**
 * A person who will be offered a bribe.
 */
@EqualsAndHashCode
class Recipient {

    static belongsTo = [benefactor: Benefactor]
    static hasMany = [bribeContracts: BribeContract]

    /** Name of the Recipient */
    String name

    static constraints = {
        name blank: false, nullable: false
    }

    @Override
    public String toString() {
        name
    }
}
