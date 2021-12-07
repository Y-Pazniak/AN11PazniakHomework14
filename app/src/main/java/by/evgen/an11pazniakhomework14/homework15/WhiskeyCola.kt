package by.evgen.an11pazniakhomework14.homework15

class WhiskeyCola(
    ice: Ice = Ice()
) : //композиция: мы прямо в конструкторе создаем объект "ice", ничего не требуем снаружи
    Whiskey("Whiskey Cola", 15, 100, ice) {

    fun drinkWithCoworkers(): String {
        return "Good chose to drink $name with your coworkers"
    }
}