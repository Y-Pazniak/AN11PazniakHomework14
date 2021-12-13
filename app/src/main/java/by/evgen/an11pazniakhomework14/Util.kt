package by.evgen.an11pazniakhomework14

import by.evgen.an11pazniakhomework14.homework15.*

class Util { //Сделать класс ‘Util’ 
    lateinit var murziksKid: InheritCatNoDataClass //будет содержать в себе поля типа класса наследника

    fun countDataClassFields(catDataClass: CatDataClass): Int { //и метод который будет считать и возвращать сумму полей data class
        var result: Int
        catDataClass.apply {
            result = (catAge + tailLength + countPaws)
        }
        return result
    }

    fun giveRandomDrink(): Spirits{
        when((Math.random()*5).toInt()){
            4 -> return WhiteRussian("White russian", 15, 100, Ice())
            3 -> return Jorsh()
            2 -> return WhiskeyCola()
            0 -> return Vodka("vodka", 40, 50)
            1 -> return Whiskey("whiskey", 43, 50, Ice())
        }
        return WhiskeyCola()
    }
}