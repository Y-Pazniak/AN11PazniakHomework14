package by.evgen.an11pazniakhomework14.homework15.data

import by.evgen.an11pazniakhomework14.homework15.util.tax

open class Whiskey(
    override val name: String = "Whiskey",
    override val alco: Int = 43,
    override val volume: Int = 50,
    val ice: Ice = Ice()
) : //агрегация - мы в конструкторе требуем передать нам чужой объект "ice"
    Spirits(name, alco, volume) {
    open var price: Int = 20
        set(price) {
            if ((price > 20) && (price < 200)) {
                field = price
            }
        }
        get() = (field * tax).toInt()

    override fun drinkAlone() = "You can drink $name alone, but company is better"

    fun drinkWithFriends() =  "Drink $name with your friends"
}