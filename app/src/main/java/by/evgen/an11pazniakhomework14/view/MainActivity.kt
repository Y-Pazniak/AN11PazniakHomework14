package by.evgen.an11pazniakhomework14.view

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import by.evgen.an11pazniakhomework14.R
import by.evgen.an11pazniakhomework14.homework15.data.*
import by.evgen.an11pazniakhomework14.homework15.observer.Editor
import by.evgen.an11pazniakhomework14.homework15.observer.UpdateDrinksListener
import by.evgen.an11pazniakhomework14.homework15.util.CatalogClass
import by.evgen.an11pazniakhomework14.homework15.util.OrderList
import by.evgen.an11pazniakhomework14.homework15.util.getInfo
import by.evgen.an11pazniakhomework14.old.CatDataClass
import by.evgen.an11pazniakhomework14.old.createNewBarsik

class MainActivity : AppCompatActivity() {
    private lateinit var result: String
    private lateinit var drinkTextView: TextView
    private lateinit var catalogTextView: TextView
    private var iter = 0
    private var catalogClass: CatalogClass<Spirits> = CatalogClass()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findFibCycle(FIB_CONST) //поиск Фибоначчи в цикле
        findFibRecursion(FIB_CONST) //поиск Фибоначчи рекурсией
        countButton() //настройка кнопки для подсчета к-ва нажатий
        createAndShowCatButton() //настройка кнопки для создания котиков Барсиков
        addNewDrink() //работа кнопки "добавить"
        showCatalog() //функция, заполняющая поле "каталог"
        printAllInfoFromSingleton()//функция, заполняющая поле "синглтон"
    }

    private fun findFibCycle(countFib: Int) {
        val fibonacciRes = findViewById<TextView>(R.id.textview_cycle_result)
        var count1 = 1
        var count2 = 1
        var countTemp: Int
        result = "$count1 $count2 "

        for (i in 0..(countFib - 3)) {
            countTemp = count1 + count2
            result += "$countTemp "
            count1 = count2
            count2 = countTemp
        }
        fibonacciRes.text = result
    }

    private fun findFibRecursion(countFib: Int) {
        val fibonacciRes = findViewById<TextView>(R.id.textview_recursion_result)
        var temp: Int
        result = ""
        for (i in 1..countFib) {
            temp =
                recursion(i) //вызов функции для рекурсивного поиска числа Фибоначчи для переданного аргумента
            result += "$temp "
        }
        fibonacciRes.text = result
    }

    private fun recursion(countFib: Int): Int = when (countFib) {
        0 -> 0
        1 -> 1
        else -> (recursion(countFib - 1) + recursion(countFib - 2))
    }

    private fun countButton() {
        val buttonCount: Button = findViewById(R.id.button_count)
        val countView = findViewById<TextView>(R.id.textview_result_count)
        var count = 0
        buttonCount.setOnClickListener {
            count++
            if (count == 666) {
                val devil: ImageView = findViewById(R.id.imageview_cute_devil)
                devil.setImageDrawable(
                    ContextCompat.getDrawable(
                        applicationContext,
                        R.drawable.devil
                    )
                )
            }
            countView.text = count.toString()
        }
    }

    private fun createAndShowCatButton() {
        /*В главном окне приложения добавить ещё одну кнопку и текстовые поля, по нажатию на кнопку необходимо
         генерировать объект data класса и все имеющиеся поля класса выводить в текстовое поле. По каждому нажатию
         необходимо сгенерировать и отобразить новый объект.*/
        val buttonCat: Button = findViewById(R.id.buttonCreateKitten)
        val catTextView = findViewById<TextView>(R.id.textviewAboutKitten)
        buttonCat.setOnClickListener {
            val newBarsik: CatDataClass = createNewBarsik()
            var aboutCat = newBarsik.toString()
            aboutCat = aboutCat.plus("\nName: " + newBarsik.name + "\n")
            aboutCat = aboutCat.plus("Have bushy mustaches? " + newBarsik.haveMustaches + "\n")
            aboutCat = aboutCat.plus("Makes relaxing purrr? " + newBarsik.makesPurrr + "\n")
            aboutCat = aboutCat.plus("Barsik's color is: " + newBarsik.color + "\n")
            aboutCat = aboutCat.plus("Usual count of Barsik's paws is: " + newBarsik.countPaws)
            catTextView.text = aboutCat
        }
    }

    private fun showCatalog() {
        catalogTextView = findViewById(R.id.textViewCatalogContent)
        var catalogText = ""
        for (spirit in catalogClass.spirits) {
            catalogText = catalogText.plus(getInfoAboutDrink(spirit))
        }
        catalogTextView.text = catalogText
    }

    private fun getInfoAboutDrink(spiritArg: Spirits): String = when(spiritArg){
        is WhiskeyCola -> spiritArg.name + "\n"
        is Jorsh -> spiritArg.name + "\n"
        is WhiteRussian -> spiritArg.name + "\n"
        is Whiskey -> spiritArg.name + "\n"
        is Vodka -> spiritArg.name + "\n"
        else -> "Unknown drink, be careful" + "\n"
    }

    private fun addNewDrink() {
        val addButton: Button = findViewById(R.id.buttonAdd)
        val testText: TextView = findViewById(R.id.textViewDrinkResult)
        val editor = Editor()
        editor.eventManager.subscribe("update", UpdateDrinksListener(testText))
        addButton.setOnClickListener {
            if (iter < catalogClass.spirits.size) { //было немного скучно брать просто первый элемент, поэтому я удалял после добавления
                OrderList.listOfDrinks.add(catalogClass.spirits[0])
                editor.updateTextView(catalogClass.spirits[0].name)
                catalogClass.spirits.removeAt(0)
            }
            //printAllInfoFromSingleton()
            showCatalog()
        }
    }

    private fun printAllInfoFromSingleton() {
        var textForTextView = ""
        drinkTextView = findViewById(R.id.textViewDrinkResult)
        for (spirit in OrderList.listOfDrinks) {
            when (spirit) {
                is WhiskeyCola -> {
                    textForTextView = textForTextView.plus(spirit.getInfo() + "\n")
                }
                is Jorsh -> {
                    textForTextView = textForTextView.plus(spirit.getInfo() + "\n")
                }
                is WhiteRussian -> {
                    textForTextView = textForTextView.plus(spirit.getInfo() + "\n")
                }
                is Whiskey -> {
                    textForTextView = textForTextView.plus(spirit.getInfo() + "\n")
                }
                is Vodka -> {
                    textForTextView = textForTextView.plus(spirit.getInfo() + "\n")
                }
            }
            drinkTextView.text = textForTextView
        }
    }

    companion object {
        const val FIB_CONST = 20
    }
}