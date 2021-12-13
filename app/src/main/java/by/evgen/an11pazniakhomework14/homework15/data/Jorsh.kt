package by.evgen.an11pazniakhomework14.homework15.data

import by.evgen.an11pazniakhomework14.homework15.util.tax

class Jorsh(
    override val name: String = "Jorsh",
    override val alco: Int = 10,
    override val volume: Int = 500,
    val beer: Beer = Beer()
) :
    Vodka() {
    override var price: Int = 15
        set(price) {
            if ((price > 15) && (price < 150)) {
                field = price
            }
        }
        get() = (field * tax).toInt()

    fun drinkToFlyAway() = "$name is good chose to fly away from your problems"
}