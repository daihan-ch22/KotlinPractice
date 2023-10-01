package dataClassPractice

data class Decoration(val rocks: String) {
    fun makeDecorations(){
        val decoration_1 = Decoration("granite")
        println(decoration_1)

        val decoration2 = Decoration("slate")
        println(decoration2)

        val decoration3 = Decoration("slate")
        println(decoration3)

        println(decoration_1.equals(decoration2))
        println(decoration2.equals(decoration3))
    }
}

data class Decoration2(val rocks: String, val wood: String, val diver: String){
    fun makeDecorations(): Decoration2{
        val deco = Decoration2("crystal", "wood", "diver")
        println(deco)

        return deco
    }
}

fun main(args: Array<String>){
    val deco = Decoration("")
    deco.makeDecorations()

    println("================")

    val deco2 = Decoration2("","","")
    val returnedValue = deco2.makeDecorations()

    println("=======Destructuring=========")
    val (rock, wood, diver) = returnedValue
    println("rock = ${rock}")
    println("wood = ${wood}")
    println("diver = ${diver}")
}