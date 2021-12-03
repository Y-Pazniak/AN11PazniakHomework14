package by.evgen.an11pazniakhomework14

class Util { //Сделать класс ‘Util’ 
    lateinit var murziksKid: InheritCatNoDataClass //будет содержать в себе поля типа класса наследника

    fun countDataClassFields(catDataClass: CatDataClass): Int { //и метод который будет считать и возвращать сумму полей data class
        var result: Int
        catDataClass.apply {
            result = (catAge + tailLength + countPaws)
        }
        return result
    }
}