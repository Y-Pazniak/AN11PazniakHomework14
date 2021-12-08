package by.evgen.an11pazniakhomework14.homework15.data

import by.evgen.an11pazniakhomework14.homework15.util.tax

class WhiteRussian(name: String = "WhiteRussian", alco: Int = 15, volume: Int = 100, ice: Ice) :
    Vodka(name, alco, volume) {
    override var price: Int = 30
        set(value) {
            if ((price > 30) && (price < 300)) {
                field = value
            }
        }
        get() {
            return (field * tax).toInt()
        }

    override fun drinkAlone(): String {
        return "You should not drink $name alone, better to share it with girls"
    }

    fun drinkToFeelAwesome(): String {
        return "Drink $name makes you feel awesome"
    }
}