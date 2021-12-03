package by.evgen.an11pazniakhomework14

class ExtendsDataClassFun { //Создать файл kotlin в котором необходимо написать функцию расширения для data класса считающую и возвращающую сумму полей data class
    fun CatDataClass.countFields(): Int {
        return this.catAge + this.tailLength + this.countPaws
    }
}