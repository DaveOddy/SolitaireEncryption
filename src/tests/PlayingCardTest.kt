package tests

import cards.PlayingCard
import org.junit.Assert.*
import org.junit.Test

class PlayingCardTest {

    @Test
    fun toStringTest() {
        assertEquals("1", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Ace).toString())
        assertEquals("2", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Two).toString())
        assertEquals("3", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Three).toString())
        assertEquals("4", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Four).toString())
        assertEquals("5", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Five).toString())
        assertEquals("6", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Six).toString())
        assertEquals("7", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Seven).toString())
        assertEquals("8", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Eight).toString())
        assertEquals("9", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Nine).toString())
        assertEquals("10", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Ten).toString())
        assertEquals("11", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Jack).toString())
        assertEquals("12", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.Queen).toString())
        assertEquals("13", PlayingCard(PlayingCard.Suit.Clubs, PlayingCard.FaceValue.King).toString())

        assertEquals("14", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Ace).toString())
        assertEquals("15", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Two).toString())
        assertEquals("16", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Three).toString())
        assertEquals("17", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Four).toString())
        assertEquals("18", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Five).toString())
        assertEquals("19", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Six).toString())
        assertEquals("20", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Seven).toString())
        assertEquals("21", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Eight).toString())
        assertEquals("22", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Nine).toString())
        assertEquals("23", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Ten).toString())
        assertEquals("24", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Jack).toString())
        assertEquals("25", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.Queen).toString())
        assertEquals("26", PlayingCard(PlayingCard.Suit.Diamonds, PlayingCard.FaceValue.King).toString())

        assertEquals("27", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Ace).toString())
        assertEquals("28", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Two).toString())
        assertEquals("29", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Three).toString())
        assertEquals("30", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Four).toString())
        assertEquals("31", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Five).toString())
        assertEquals("32", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Six).toString())
        assertEquals("33", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Seven).toString())
        assertEquals("34", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Eight).toString())
        assertEquals("35", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Nine).toString())
        assertEquals("36", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Ten).toString())
        assertEquals("37", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Jack).toString())
        assertEquals("38", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.Queen).toString())
        assertEquals("39", PlayingCard(PlayingCard.Suit.Hearts, PlayingCard.FaceValue.King).toString())


        assertEquals("40", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Ace).toString())
        assertEquals("41", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Two).toString())
        assertEquals("42", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Three).toString())
        assertEquals("43", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Four).toString())
        assertEquals("44", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Five).toString())
        assertEquals("45", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Six).toString())
        assertEquals("46", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Seven).toString())
        assertEquals("47", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Eight).toString())
        assertEquals("48", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Nine).toString())
        assertEquals("49", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Ten).toString())
        assertEquals("50", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Jack).toString())
        assertEquals("51", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.Queen).toString())
        assertEquals("52", PlayingCard(PlayingCard.Suit.Spades, PlayingCard.FaceValue.King).toString())
    }
}