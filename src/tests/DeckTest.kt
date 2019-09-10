package tests

import cards.*
import org.junit.Test

import org.junit.Assert.*

class DeckTest {

    @Test (expected = IllegalStateException::class)
    fun constructorWithNoCards() {
        Deck(getNoCardsDeckLoader())
    }


    @Test (expected = IllegalStateException::class)
    fun constructorWithNoJokers() {
        Deck(getNoJokersDeckLoader())
    }


    @Test (expected = IllegalStateException::class)
    fun constructorWithOneJoker() {
        Deck(getOneJokerDeckLoader())
    }


    @Test (expected = IllegalStateException::class)
    fun constructorWithThreeJokers() {
        Deck(getThreeJokersDeckLoader())
    }


    @Test
    fun constructor() {
        val deck = Deck(UnKeyedDeckLoader())

        var item: Deck.Item? = deck.head
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Ace, (item.card as PlayingCard).faceValue)

        item = item.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Two, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Three, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Four, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Five, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Six, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Seven, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Eight, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Nine, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Ten, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Jack, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Queen, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Clubs, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.King, (item?.card as PlayingCard).faceValue)


        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Ace, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Two, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Three, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Four, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Five, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Six, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Seven, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Eight, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Nine, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Ten, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Jack, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Queen, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Diamonds, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.King, (item?.card as PlayingCard).faceValue)


        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Ace, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Two, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Three, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Four, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Five, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Six, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Seven, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Eight, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Nine, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Ten, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Jack, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Queen, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Hearts, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.King, (item?.card as PlayingCard).faceValue)


        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Ace, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Two, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Three, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Four, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Five, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Six, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Seven, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Eight, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Nine, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Ten, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Jack, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.Queen, (item?.card as PlayingCard).faceValue)

        item = item?.next
        assert(item?.card is PlayingCard)
        assertEquals(PlayingCard.Suit.Spades, (item?.card as PlayingCard).suit)
        assertEquals(PlayingCard.FaceValue.King, (item?.card as PlayingCard).faceValue)


        item = item?.next
        assert(item?.card is Joker)
        assertEquals(Joker.AorB.A, (item?.card as Joker).which)

        item = item.next
        assert(item?.card is Joker)
        assertEquals(Joker.AorB.B, (item?.card as Joker).which)

        item = item?.next
        assertNull(item)
    }


    @Test
    fun getKeyString() {

        val deck = Deck(UnKeyedDeckLoader())
        val keyString = deck.getKeyStream(25)

        assertEquals("DWJXHYRFDGTMSHPUURXJZYWYH", keyString)
    }


    private fun getNoCardsDeckLoader() : Deck.DeckLoader {
        return object : Deck.DeckLoader {
            override fun requestCard(): Card? {
                return null
            }

        }
    }


    private fun getNoJokersDeckLoader() : Deck.DeckLoader {
        return object : UnKeyedDeckLoader() {

            override fun getCardList() = listOf(
                PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Ace)
                , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Ace)
                , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Ace)
                , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Ace)
            )
        }
    }


    private fun getOneJokerDeckLoader() : Deck.DeckLoader {
        return object : UnKeyedDeckLoader() {

            override fun getCardList() = listOf(
                PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Ace)
                , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Ace)
                , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Ace)
                , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Ace)

                , Joker(Joker.AorB.A)
            )
        }
    }


    private fun getThreeJokersDeckLoader() : Deck.DeckLoader {
        return object : UnKeyedDeckLoader() {

            override fun getCardList() = listOf(
                PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Ace)
                , PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Ace)
                , PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Ace)
                , PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Ace)

                , Joker(Joker.AorB.A)
                , Joker(Joker.AorB.B)
                , Joker(Joker.AorB.A)
            )
        }
    }
}