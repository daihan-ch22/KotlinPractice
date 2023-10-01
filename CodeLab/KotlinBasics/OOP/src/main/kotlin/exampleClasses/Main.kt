package exampleClasses

fun main(args: Array<String>) {

    //makeFish()
}

fun makeAquarium(){
    println("=== Kotlin Class Practice - Aquarium ===")

    var mAquarium = Aquarium()

    mAquarium.buildAquarium().run {

    }

    mAquarium.buildAquariumWithShape()
}

fun makeFish() {
    println("==========ABSTRACT CLASS STARTS===========")

    val shark = Shark("sardine")
    val pleco = Plecostomus()
    GoldColor.color = "GOLD"

    println("Shark: ${shark.color}")
    shark.eat()

    println("Plecostomus: ${pleco.color}")
    pleco.eat()

}