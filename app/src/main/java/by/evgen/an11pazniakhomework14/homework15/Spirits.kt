package by.evgen.an11pazniakhomework14.homework15

abstract class Spirits(open val name: String, open val alco: Int, open val volume: Int) {
    open fun drinkAlone(): String{
        return "To $name spirit alone"
    }
}