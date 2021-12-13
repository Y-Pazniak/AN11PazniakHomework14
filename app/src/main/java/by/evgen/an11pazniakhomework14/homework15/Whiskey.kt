package by.evgen.an11pazniakhomework14.homework15

open class Whiskey(
    override val name: String = "Whiskey",
    override val alco: Int = 40,
    override val volume: Int = 500,
    val ice: Ice = Ice()
) : //агрегация - мы в конструкторе требуем передать нам чужой объект "ice"
    Spirits(name, alco, volume) {
    override fun drinkAlone(): String {
        return "You can drink $name alone, but company is better"
    }

    fun drinkWithFriends(): String {
        return "Drink $name with your friends"
    }
}