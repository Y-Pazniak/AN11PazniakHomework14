package by.evgen.an11pazniakhomework14.old

open class CatNoDataClass(
    val catAge: Int,
    val tailLength: Int
) {
    val name = "Murzik"
    val haveMustaches = true
    val makesPurrr = true
    val color = "red"
    val countPaws = 4
}

fun createNewMurzik(): CatNoDataClass {
    return CatNoDataClass(((Math.random() * 10).toInt()), ((Math.random() * 15).toInt()))
}