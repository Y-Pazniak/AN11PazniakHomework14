package by.evgen.an11pazniakhomework14.homework15.data

import by.evgen.an11pazniakhomework14.homework15.util.tax

class WhiskeyCola(
    ice: Ice = Ice()
) : //композиция: мы прямо в конструкторе создаем объект "ice", ничего не требуем снаружи
    Whiskey("Whiskey Cola", 15, 100, ice) {
    override var price: Int = 20
        set(value) {
            if ((value > 20) && (value < 200)) {
                field = value
            }
        }
        get() {
            return (field * tax).toInt()
        }


    fun drinkWithCoworkers(): String {
        return "Good chose to drink $name with your coworkers"
    }
}