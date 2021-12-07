package by.evgen.an11pazniakhomework14.homework15

object OrderList {
    var listOfDrinks: ArrayList<Spirits> =
        arrayListOf(
            Jorsh(),
            Vodka(),
            WhiskeyCola(),
            Whiskey(),
            WhiteRussian(ice = Ice())
        )
}