package by.evgen.an11pazniakhomework14.homework15

object OrderList {
    var listOfDrinks: ArrayList<Spirits> =
        arrayListOf(
            Jorsh(),
            Vodka("Vodka", 40, 50),
            WhiskeyCola(),
            Whiskey("Whiskey", 43, 50, Ice()),
        )
}