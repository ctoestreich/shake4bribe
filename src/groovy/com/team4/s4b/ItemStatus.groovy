package com.team4.s4b

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType

/**
 * Represents the concrete status that an item can be in
 */
@XmlAccessorType(XmlAccessType.FIELD)
enum ItemStatus implements Serializable {

    uncompleted(false),
    completed(true)

    private final Boolean value

    public Boolean value() { return value }

    ItemStatus(Boolean value) {this.value = value}

    public static ItemStatus getItemStatus(Boolean value) {
        ItemStatus.values()?.each { itemStatus ->
            if(value == itemStatus.value) {
                return itemStatus
            }
        }
        return null
    }
}