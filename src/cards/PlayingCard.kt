package cards

data class PlayingCard(val suit: Suit, val faceValue: FaceValue) : Card() {

    override fun cardValue() = this.suit.offset + this.faceValue.value

    override fun toString() = "${this.cardValue()}"

    enum class Suit(val offset: Int) {
        Clubs(0), Diamonds(13), Hearts(26), Spades(39)
    }

    enum class FaceValue(val value: Int) {
        Ace(1)
        , Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10)
        , Jack(11), Queen(12), King(13)
    }
}