package by.evgen.an11pazniakhomework14.homework15.util

import by.evgen.an11pazniakhomework14.homework15.data.*
import by.evgen.an11pazniakhomework14.old.CatDataClass
import by.evgen.an11pazniakhomework14.old.InheritCatNoDataClass

fun WhiskeyCola.getInfo() =
    "name: " + this.name + ", capacity: " + this.volume + ", alcohol: " + this.alco

fun Whiskey.getInfo() =
    "name: " + this.name + ", capacity: " + this.volume + ", alcohol: " + this.alco

fun Jorsh.getInfo() =
    "name: " + this.name + ", capacity: " + this.volume + ", alcohol: " + this.alco

fun Vodka.getInfo() =
    "name: " + this.name + ", capacity: " + this.volume + ", alcohol: " + this.alco

fun WhiteRussian.getInfo() =
    "name: " + this.name + ", capacity: " + this.volume + ", alcohol: " + this.alco

val tax = 1.2
val vodkaPrice = 15
val jorshPrice = 20
val whiskeyPrice = 25
val whiskeyColaPrice = 25
val whiteRussianPrice = 30

class Util { //Сделать класс ‘Util’
    lateinit var murziksKid: InheritCatNoDataClass //будет содержать в себе поля типа класса наследника

    fun countDataClassFields(catDataClass: CatDataClass): Int { //и метод который будет считать и возвращать сумму полей data class
        var result: Int
        catDataClass.apply {
            result = (catAge + tailLength + countPaws)
        }
        return result
    }

    fun giveRandomDrink(): Spirits {
        when ((Math.random() * 5).toInt()) {
            4 -> return WhiteRussian("White russian", 15, 100, Ice())
            3 -> return Jorsh()
            2 -> return WhiskeyCola()
            0 -> return Vodka("vodka", 40, 50)
            1 -> return Whiskey("whiskey", 43, 50, Ice())
        }
        return WhiskeyCola()
    }
}