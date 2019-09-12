package tests

import cards.SolitaireKeyDeck
import cards.UnKeyedDeckLoader
import org.junit.Assert.*
import org.junit.Test

class SolitaireKeyDeckTest {

    @Test
    fun getKeyString() {

        val deck = SolitaireKeyDeck(UnKeyedDeckLoader())
        val keyString = deck.getKeyStream(25)

        assertEquals("DWJXHYRFDGTMSHPUURXJZYWYH", keyString)
    }

}