package by.evgen.an11pazniakhomework14.homework15.util

import by.evgen.an11pazniakhomework14.homework15.data.*

object OrderList {
    var listOfDrinks: ArrayList<Spirits> =
        arrayListOf(
            Jorsh(),
            Vodka(),
            WhiskeyCola(),
            Whiskey(),
            WhiteRussian(ice = Ice())
        )
}