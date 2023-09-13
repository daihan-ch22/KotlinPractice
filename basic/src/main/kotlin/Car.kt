class Car (){

    //field
    private val doorLock: Boolean = false

    fun getDoorLockStatus(): String {

        val doorLockClass: DoorLock = DoorLock()

        return doorLockClass.isDoorLocked()
    }

    class DoorLock{
        private val isLocked: Boolean = true
        lateinit var answerString: String

        fun isDoorLocked(): String {
            when{
                isLocked -> answerString = isLocked.toString()
                !isLocked -> answerString = isLocked.toString()
            }
            return answerString
        }
    }
}