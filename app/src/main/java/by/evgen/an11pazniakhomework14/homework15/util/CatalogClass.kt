package by.evgen.an11pazniakhomework14.homework15.util

import by.evgen.an11pazniakhomework14.homework15.data.*

class CatalogClass<s : Spirits> {
    val spirits: ArrayList<Spirits> =
        arrayListOf(Jorsh(), Vodka(), Whiskey(), WhiskeyCola(), WhiteRussian(ice = Ice()))
}