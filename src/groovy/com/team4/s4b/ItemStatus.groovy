package com.team4.s4b

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType

/**
 * Represents the concrete status that an item can be in
 */
@XmlAccessorType(XmlAccessType.FIELD)
enum ItemStatus implements Serializable {

    uncompleted(0),
    completed(1)

    private final int value

    public int value() { return value }

    ItemStatus(int value) {this.value = value}

    public static ItemStatus getItemStatus(int value) {
        ItemStatus.values()?.each { itemStatus ->
            if(value == itemStatus.value) {
                return itemStatus
            }
        }
        return null
    }
}