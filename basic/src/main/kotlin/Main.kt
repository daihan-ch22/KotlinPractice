import com.sun.jdi.DoubleValue
import com.sun.jdi.FloatValue
import java.lang.StringBuilder

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")


    println(variableCheck(floatValue = 3.33f, doubleValue = 2.2))

}

private fun variableCheck(integerVal: Int = 3000, stringVal: String = "DEFAULTSTR", doubleValue: Double, floatValue: Float): String{

    var changingNum = 31313131 + integerVal

    val sb: StringBuilder = StringBuilder()
    sb.append("======variableCheck start======").append("\n").append("integerVal : ").append(changingNum).append("\n")
        .append("stringVal : ").append(stringVal)
        .append("\n").append("doubleVal : ").append(doubleValue).append("\n").append("floatVal : ").append(floatValue)
        .append("\n").append("======variableCheck end======")

    return sb.toString()
}


