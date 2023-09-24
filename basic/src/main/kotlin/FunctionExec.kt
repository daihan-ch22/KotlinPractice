import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStream
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue
import kotlin.random.Random

class FunctionExec {

    private lateinit var day : String
    private lateinit var food: String

    constructor(food: String){
        this.food = food
        this.day = getRandomDay()
    }

    fun getFoodAndDate(): Unit {
        println("Today is $day and your food is $food");
    }

    private fun getRandomDay(): String {
        val week = arrayListOf<String>("Mon", "Tue", "Wed", "Thur", "Fri", "Sat", "Sun")

        getEagerFilterFunc(week)
        getLazyFilterFunc(week)

        val day = week[Random.nextInt(week.size)]
        getRandomFoodByDay(day)

        return day
    }

    private fun getRandomFoodByDay(day: Any){

        val br = BufferedReader(InputStreamReader(System.`in`))

        when(day){
            "Mon" -> food = "Mango"
            "Tue" -> food = "Cheese"
            "Wed" -> food = "Kimchi"
            "Thur" -> food = "Nogari"
            "Fri" -> food = "AppleJuice"
            "Sat" -> food = "Fried Egg"
            "Sun" -> food = null.toString()
        }
    }

    /**
     * EAGER FILTERING
     */
    private fun getEagerFilterFunc(list: ArrayList<String>): ArrayDeque<String>{

        val filteredList = ArrayDeque<String>()
        val filter = list.filter { it.startsWith("M") }

        for(element in filter){
            filteredList.addFirst(element)
            println(" filter will do filtering eagerly")
            println(" $element is added to filteredListQueue! \ncurrent Queue size is ${filteredList.size}")
        }

        return filteredList
    }

    /**
     * LAZY FILTERING
     */
    private fun getLazyFilterFunc(list: ArrayList<String>): Unit{
        list.asSequence().filter { it.startsWith("M") }
        var filteredMap = list.asSequence().map {
            println("access: $it")
        }

        println(filteredMap.toString())
    }


}