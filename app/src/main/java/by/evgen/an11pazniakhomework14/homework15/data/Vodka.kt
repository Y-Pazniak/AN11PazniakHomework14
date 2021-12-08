package by.evgen.an11pazniakhomework14.homework15.data

import by.evgen.an11pazniakhomework14.homework15.util.tax

open class Vodka(
    override val name: String = "Vodka",
    override val alco: Int = 40,
    override val volume: Int = 50
) :
    Spirits(name, alco, volume) {

    open var price: Int = 10
        set(price) {
            if ((price > 10) && (price < 100)) {
                field = price
            }
        }
        get() {
            return (field * tax).toInt()
        }



    override fun drinkAlone(): String {
        return "You can drink $name alone, it is OK"
    }

    fun drinkLikeACure(): String {
        return "You can drink $name like a cure"
    }
}