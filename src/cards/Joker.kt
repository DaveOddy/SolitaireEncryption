package cards

data class Joker(val which: AorB) : Card() {

    companion object {
        val JOKER_VALUE = 53
    }

    override fun cardValue() = JOKER_VALUE

    override fun toString() = "J${which}"

    enum class AorB { A, B }
}