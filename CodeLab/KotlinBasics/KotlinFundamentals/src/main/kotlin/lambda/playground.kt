package lambda

import java.util.Arrays

fun main(args: Array<String>) {
    val trickFunction = ::trick //assigning function into variable
    val trickFunction2 = trick()

    trick()
    trickFunction()
    treat()

    ////
    println("/////////")

    val coins: (Int) -> String = { quantity ->
        "$quantity quarters"
    }

    val cupcake: (Int) -> String = { quantity ->
        "Have a cupcake!"
    }

    val _treatFunction = trickOrTreat(false) {
        "$it quarters"
    }
    val _trickFunction = trickOrTreat(true, null)
    _treatFunction()
    _trickFunction()

    //////
    println("////////")
    println("repeat() function is similar as loop - higher-order function")
    repeat(4){
        _treatFunction()
    }
    _trickFunction()
}

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int)-> String)?): () -> Unit {
    if(isTrick){
        return trick
    } else {
        if(extraTreat != null) {
            println(extraTreat(5))
        }
        return treat
    }
}

val trick = {
    println("no treats!")
}

val treat: () -> Unit = {
    println("Have a treat!")
}