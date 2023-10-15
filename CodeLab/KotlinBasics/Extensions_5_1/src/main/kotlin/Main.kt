import CompanionClass.Companion.CONST2

fun main(args: Array<String>) {

    //List - readOnly
    //MutableList - read,write
    val test_pairsAndTriples = PairsAndTriples()
    test_pairsAndTriples.getPairsAndTriples()

    val test_collections = CompCollections()
    test_collections.getList()
    test_collections.getHashMap()
    test_collections.getMutableMap()

    //const val vs val
    println("const val -- assigned in compile time")
    println("val -- assigned during runtime")
    println(Constants.CONST)

    println(CONST2)

    println("=========write extensions==========")
    WriteExtensions.writeExtensions()

    val getsetPrac = GetSetPractice("Android", "Watch", 0)
    println(getsetPrac.getDeviceStatus1())
}

class CompanionClass {
    companion object {
        const val CONST2 = "constant in companion"
    }
}

class CompCollections{
    fun getList(){

        println("COLLECTIONS-LIST ============")

        //list
        val list = listOf(1, 5, 3, 4)
        println("SUM:: ${list.sum()}")

        //adding String list
        val list2 = listOf("a", "bbb", "cc")
        println("StringSUM:: ${list2.sumOf { it.length } }")

        for( element in list2.listIterator()){
            println("ELEMENT:: $element")
        }
    }

    fun getHashMap(){
        println("COLLECTIONS-HASHMAP ============")

        //MapOf - readOnly
        //hashMapOf - mutable
        val cures = hashMapOf("white spots" to "Ich", "red sores" to "hole disease")
        println(cures.get("white spots"))
        println(cures["red sores"]) // same as get()

        println(cures.getOrDefault("emptyKeywillCauseNull", "sorry I don't know"))

        println(cures.getOrElse("notAKey") {
            //not just returning value, but can execute some codes
            for( intVal: Int in 1..10){
                print(intVal)
            }
            "forLoop executed!"
        })
    }

    fun getMutableMap(){
        println("COLLECTIONS-MutableMap ============")
        val inventory = mutableMapOf("fish net" to 1)
        inventory.put("tank scrubber", 3)
        println(inventory.toString())
        inventory.remove("fish net")
        println(inventory.toString())
    }
}


class PairsAndTriples{
    fun getPairsAndTriples(){
        //Pair
        val equipment = "fish net" to "catching fish"
        println("PAIRS:: ${equipment.first} used for ${equipment.second}")


        //Triple
        val numbers = Triple(6,9,42)
        println("toString:: ${numbers.toString()}")
        println("toList:: ${numbers.toList()}")


        val equipment2 = ("fish net" to "catching fish") to "equipment"
        println("${equipment2.first} is ${equipment2.second}\n")
        println("${equipment2.first.second}") //catching fish


        //Destructuring pairs
        val (tool, use) = equipment // fish net, catching fish
        println("$tool is used for $use")

        //Destructuring Triples
        val (n1, n2, n3) = numbers
        println("$n1, $n2, $n3 \n")
    }
}