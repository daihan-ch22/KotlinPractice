package practiceSession

class Foldable_Phones: Phone(),AnswerTemplate{

    private var isFolded: Boolean = true

    override fun executeAnswer() {
        switchOn()
        checkPhoneScreenLight()
        unFoldDevice()
        switchOn()
        checkPhoneScreenLight()
    }

    override fun switchOn() {
        if(!isFolded){
            isScreenLightOn = true
        }
    }

    private fun foldDevice(){
        isFolded = true
    }

    private fun unFoldDevice(){
        isFolded = false
    }
}

open class Phone(var isScreenLightOn: Boolean = false){
    open fun switchOn() {
        isScreenLightOn = true
    }

    fun switchOff(){
        isScreenLightOn = false
    }

    fun checkPhoneScreenLight() {
        val phoneScreenLight = if(isScreenLightOn) "On" else "off"
        println("The phone screen's light is $phoneScreenLight.")
    }
}