package practiceSession

class Temperature_Converter : AnswerTemplate{

    private val UNIT_CELSIUS = "Celsius"
    private val UNIT_FARENHEIT = "Farenheit"
    private val UNIT_KELVIN = "Kelvin"

    override fun executeAnswer() {
        printFinalTemperature(27.0, UNIT_CELSIUS, UNIT_FARENHEIT) { it * 9 / 5 + 32 }
        printFinalTemperature(350.0, UNIT_KELVIN, UNIT_CELSIUS) { it - 273.15 }
        printFinalTemperature(10.0, UNIT_FARENHEIT, UNIT_KELVIN) { (it - 32) * 5 / 9 + 273.15}
    }

    fun printFinalTemperature(
        initialMeasurement: Double,
        initialUnit: String,
        finalUnit: String,
        conversionFormula: (Double) -> Double
    ){
        val finalMeasurement = String.format("%.2f", conversionFormula(initialMeasurement))
        println("$initialMeasurement degrees $initialUnit is $finalMeasurement degrees $finalUnit.")
    }
}