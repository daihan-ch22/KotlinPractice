package exampleClasses

/*abstract class AquariumFish {
    abstract val color: String
}*/

class Shark(var food: String): FishActions, FishColor {
    override var color: String = "Cyan"
    override fun eat() {
        color = "brown"
        println("hunt and eat ${food}!")
    }

}

class Plecostomus(fishColor: FishColor = GoldColor):
    FishActions by PrintingFishActions("eat algae"),
    FishColor by GoldColor

class PrintingFishActions(val food: String): FishActions{
    override fun eat() {
        println(food)
    }
}

object GoldColor : FishColor {

    private var receivedColorVal: String = "Color not yet decided"
    override var color: String
        get() = receivedColorVal
        set(value) {
            receivedColorVal = value
        }
}