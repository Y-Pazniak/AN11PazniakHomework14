package by.evgen.an11pazniakhomework14.homework15.data

abstract class Spirits(open val name: String, open val alco: Int, open val volume: Int) {
    open fun drinkAlone() = "To $name spirit alone"
}