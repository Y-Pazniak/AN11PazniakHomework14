package by.evgen.an11pazniakhomework14.homework15

open class Vodka(override val name: String = "Vodka", override val alco: Int = 40, override val volume: Int = 50) :
    Spirits(name, alco, volume) {
    override fun drinkAlone(): String {
        return "You can drink $name alone, it is OK"
    }

    fun drinkLikeACure(): String {
        return "You can drink $name like a cure"
    }
}