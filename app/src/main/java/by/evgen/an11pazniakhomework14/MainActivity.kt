package by.evgen.an11pazniakhomework14

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import by.evgen.an11pazniakhomework14.homework15.*

class MainActivity : AppCompatActivity() {
    private lateinit var result: String
    private lateinit var drinkTextView: TextView
    private var iter = 0
    private var isFirstClick = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findFibCycle(20) //поиск Фибоначчи в цикле
        findFibRecursion(20) //поиск Фибоначчи рекурсией
        countButton() //настройка кнопки для подсчета к-ва нажатий
        createAndShowCatButton() //настройка кнопки для создания котиков Барсиков
        showNextDrink() //работа кнопки "следующий"
        showPreviousDrink() //работа кнопки "предыдущий"
        addNewDrink() //работа кнопки "добавить"
        delete() //работа кнопки "удалить
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

    private fun recursion(countFib: Int): Int {
        val result = when (countFib) {
            0 -> 0
            1 -> 1
            else -> (recursion(countFib - 1) + recursion(countFib - 2))
        }
        return result
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

    private fun showNextDrink() {
        val nextButton: Button = findViewById(R.id.buttonNext)
        nextButton.setOnClickListener {
            if (OrderList.listOfDrinks.size > 0) {
                if (isFirstClick) {
                    printAboutCocktail(0)
                    isFirstClick = false
                } else {
                    if (iter < OrderList.listOfDrinks.size - 1) {
                        iter++
                        printAboutCocktail(iter)
                    } else {
                        printAboutCocktail(0)
                        iter = 0
                    }
                }
            }
        }
    }

    private fun showPreviousDrink() {
        drinkTextView = findViewById(R.id.textViewDrinkResult)
        val prevButton: Button = findViewById(R.id.buttonPrevious)
        prevButton.setOnClickListener {
            if (OrderList.listOfDrinks.size > 0) {
                if (isFirstClick) {
                    printAboutCocktail(0)
                    isFirstClick = false
                } else {
                    if (iter == 0) {
                        iter = OrderList.listOfDrinks.size - 1
                        printAboutCocktail(iter)
                    } else {
                        iter -= 1
                        printAboutCocktail(iter)
                    }
                }
            }
        }
    }

    private fun addNewDrink() {
        val addButton: Button = findViewById(R.id.buttonAdd)
        addButton.setOnClickListener {
            drinkTextView = findViewById(R.id.textViewDrinkResult)
            val spirit: Spirits = Util().giveRandomDrink()
            OrderList.listOfDrinks.add(spirit)
            drinkTextView.text = "${spirit.name} - added"
        }
    }

    private fun printAboutCocktail(number: Int) {
        drinkTextView = findViewById<TextView>(R.id.textViewDrinkResult)
        val textToView: String
        when (val spirit: Spirits = OrderList.listOfDrinks[number]) {
            is WhiskeyCola -> {
                textToView =
                    spirit.getInfo() + "\n" + spirit.drinkWithCoworkers() + "\n" + spirit.drinkWithFriends() + "\n" + spirit.drinkAlone()
                drinkTextView.text = textToView
            }
            is Jorsh -> {
                textToView =
                    spirit.getInfo() + "\n" + spirit.drinkToFlyAway() + "\n" + spirit.drinkLikeACure() + "\n" + spirit.drinkAlone()
                drinkTextView.text = textToView
            }
            is WhiteRussian -> {
                textToView =
                    spirit.getInfo() + "\n" + spirit.drinkToFeelAwesome() + "\n" + spirit.drinkLikeACure() + "\n" + spirit.drinkAlone()
                drinkTextView.text = textToView
            }
            is Whiskey -> {
                textToView =
                    spirit.getInfo() + "\n" + spirit.drinkWithFriends() + "\n" + spirit.drinkAlone()
                drinkTextView.text = textToView
            }
            is Vodka -> {
                textToView =
                    spirit.getInfo() + "\n" + spirit.drinkLikeACure() + "\n" + spirit.drinkAlone()
                drinkTextView.text = textToView
            }
        }
    }

    private fun delete() {
        val removeButton: Button = findViewById(R.id.buttonDelete)
        removeButton.setOnClickListener {
            drinkTextView = findViewById<TextView>(R.id.textViewDrinkResult)
            if (OrderList.listOfDrinks.size > 0 && drinkTextView.text.isNotEmpty()) {
                OrderList.listOfDrinks.removeAt(iter)
            }
            drinkTextView.text = ""
        }
    }
}