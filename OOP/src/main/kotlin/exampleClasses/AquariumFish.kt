package exampleClasses

/*abstract class AquariumFish {
    abstract val color: String
}*/

class Shark: FishActions{

    override val color = "black"
    override fun eat() {
        println("hunt and eat fish!")
    }

}

class Plecostomus: FishActions{
    override val color: String = "gold"
    override fun eat() {
        println("eat algae")
    }
}