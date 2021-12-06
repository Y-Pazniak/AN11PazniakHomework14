package by.evgen.an11pazniakhomework14.homework15

open class Whiskey(
    val name: String,
    val alco: Int,
    val volume: Int,
    val ice: Ice
) : //агрегация - мы в конструкторе требуем передать нам чужой объект "ice"
    Spirits() {
}