package by.evgen.an11pazniakhomework14.homework15

class Jorsh(
    override val name: String = "Jorsh", override val alco: Int = 10, override val volume: Int = 500,
    val beer: Beer = Beer()
) :
    Vodka() {

    fun drinkToFlyAway(): String {
        return "$name is good chose to fly away from your problems"
    }
}