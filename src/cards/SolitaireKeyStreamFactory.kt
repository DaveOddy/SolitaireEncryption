package cards

import crypto.Crypto

class SolitaireKeyStreamFactory(val deckLoader: Deck.DeckLoader) : Crypto.KeyStreamFactory {
    override fun getKeyStream(length: Int): String {
        return Deck(deckLoader).getKeyStream(length)
    }
}