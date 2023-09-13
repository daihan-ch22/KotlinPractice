import com.sun.jdi.DoubleValue
import com.sun.jdi.FloatValue
import java.lang.StringBuilder

fun main(args: Array<String>) {
    println("Hello World!")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")


    println(variableCheck(floatValue = 3.33f, doubleValue = 2.2))

    val answerString: String = generateString(2)
    println("answer string is $answerString")

    //Anonymous Function
    val stringLengthFunc: (String) -> Int = {
        inputString -> inputString.length
    }

    println("anonymousFunc: ${stringLengthFunc("test")}")


    stringMapper("stringMapper", {input -> input.length} )

    //if anonymous function is the last parameter, it parentheses can be removed
    val stringMapperInt: Int = stringMapper("stringMapper2") {input -> input.length}
    println("stringMapperInt is $stringMapperInt")


    val car = Car()
    val doorLockStatus = car.getDoorLockStatus()

    println("current doorlock status is $doorLockStatus")
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

private fun generateString(inputCount: Int): String {
    val count: Int = 333

    val answerString: String = if(count > inputCount){
        "I have the answer"
    } else {
        "I don't have the answer"
    }
    return answerString
}

private fun simplifiedGenerateString(inputCount: Int): String {
    return if(33 > inputCount){
        "I have simplified answer"
    } else {
        "don't have simplified answer"
    }
}

//Higher-Order Functions
private fun stringMapper(string: String, mapper: (String) -> Int): Int {
    //Invoke function
    return mapper(string)
}



