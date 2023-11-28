package high_order_functions

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

/**
 * map() - 특정 타입으로 변환
 */
val fullMenu = cookies.map {
    "${it.name} - $${it.price}"
}

/**
 * 배열 loop
 */
fun forEach() {
    cookies.forEach {
        println("Menu item = ${it.name}")
    }
}

fun printFullMenu() {
    println("Full Menu : ")
    fullMenu.forEach {
        println(it)
    }
}

/**
 * Filter()
 */
fun printSoftCookie() {
    val softBakedMenu = cookies.filter {
        it.softBaked
    }
    println("SoftCookie: ")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
}

/**
 * GroupBy()
 * LIST -> MAP
 * @return Map<K,V>
 */
fun printSoftCookieByGroupBy() {
    println("=============================")
    val groupMenu = cookies.groupBy {
        it.softBaked
    }

    val softBakedMenu = groupMenu[true] ?: listOf()
    val chunkyBakedMenu = groupMenu[false] ?: listOf()

    println("Soft Baked Cookies:")
    softBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
    println()
    println("Chunky Baked Cookies:")
    chunkyBakedMenu.forEach {
        println("${it.name} - $${it.price}")
    }
}

/**
 * Fold()
 * multiple numbers -> one element (sum, result, etc)
 * same as reduce()
 * target.fold(numFormat){ do Stuff here }
 */
fun getTotalPrice() {
    println()
    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }

    println("Total Cookie Price = $$totalPrice")
}


/**
 * sortedBy()
 * -> define how to sort data by "What"
 */
fun getSortedData(){

    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
    var count = 1
    alphabeticalMenu.forEach {
        println("SORTED BY ALPHABETICAL ORDER: ${count++} ${it.name}")
    }
}

fun main() {
    forEach()

    printFullMenu()

    //printSoftCookie()
    printSoftCookieByGroupBy()
    getTotalPrice()
    getSortedData()
}