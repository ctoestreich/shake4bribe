package com.team4.s4b.domain

import groovy.transform.ToString
import groovy.transform.EqualsAndHashCode

/**
 * Class that represents a bribe to be given.
 */
@ToString
@EqualsAndHashCode
class Bribe {

    static belongsTo = [bribePortfolio: BribePortfolio]

    /** Name of the bribe. */
    String name
    /** Hyperlink to external website if bribe exists on the web. */
    String link
    /** A picture of the bribe */
    byte[] picture = null
    /** Probability that the bribe will occur.  Value will range from 1-100.  Default will be 1. */
    Integer probability = 1
    /** How many of this bribe are available.  Value of -1 means unlimted.  Once 0 is reached this will no longer show up in bribe portfolio shake. */
    Integer availableCount = -1

    static constraints = {
        name blank: false, nullable: false
        probability range: 1..99999
        picture nullable: true, maxSize: 1024*1000
    }

    static mapping = {
        picture sqlType: "blob"
    }

    @Override
    public String toString() {
        return "Bribe{" +
               "name='" + name + '\'' +
               ", probability=" + probability +
               ", availableCount=" + availableCount +
               ", id=" + id +
               '}';
    }
}
