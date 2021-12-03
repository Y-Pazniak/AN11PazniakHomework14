package by.evgen.an11pazniakhomework14

data class CatDataClass(
    val catAge: Int,
    val tailLength: Int
) { //Создать data класс с 2 полями типа int и 5 любыми полями.
    val name = "Barsik"
    val haveMustaches = true
    val makesPurrr = true
    val color = "red"
    val countPaws = 4
}

fun createNewBarsik(): CatDataClass {
    return CatDataClass(((Math.random() * 10).toInt()), ((Math.random() * 15).toInt()))
}

