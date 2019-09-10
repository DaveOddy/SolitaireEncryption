package cards

open class UnKeyedDeckLoader : Deck.DeckLoader {

    private val cardList = getCardList()
    private var nextIndex = 0

    override fun requestCard(): Card? {
        val cards = this.cardList
        if (this.nextIndex < cards.size) {
            return cards[this.nextIndex++]
        } else {
            this.nextIndex = 0
            return null
        }
    }

    open protected fun getCardList() = listOf(
        PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Ace)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Two)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Three)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Four)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Five)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Six)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Seven)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Eight)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Nine)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Ten)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Jack)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Queen)
        , PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.King)

        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Ace)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Two)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Three)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Four)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Five)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Six)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Seven)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Eight)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Nine)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Ten)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Jack)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Queen)
        , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.King)

        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Ace)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Two)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Three)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Four)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Five)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Six)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Seven)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Eight)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Nine)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Ten)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Jack)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Queen)
        , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.King)

        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Ace)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Two)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Three)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Four)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Five)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Six)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Seven)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Eight)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Nine)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Ten)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Jack)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Queen)
        , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.King)

        , Joker(Joker.AorB.A)
        , Joker(Joker.AorB.B)
    )
}