class AquariumPlant(val color: String, private val size: Int) {

    fun AquariumPlant.isRed() = color == "red"

    fun AquariumPlant.isBig() = size > 50
}
