package cards

class SolitaireKeyDeck(loader: DeckLoader) : Deck(loader) {

    companion object {

        private val LETTERS_IN_ALPHABET = 26

        private val ASCII_A = 65
    }



    fun getKeyStream(size: Int) : String {
        val builder = StringBuilder()
        while (builder.length < size) {
            moveJokerA()
            moveJokerB()
            tripleCut()
            countCut()
            builder.append(getOutputLetter())
        }

        return builder.toString()
    }


    private fun moveJokerA() {
        moveItemDownOne(this.jokerA)
    }


    private fun moveJokerB() {
        moveItemDownOne(this.jokerB)
        moveItemDownOne(this.jokerB)
    }


    private fun tripleCut() {
        val topJoker = findTopJoker()
        val bottomJoker = findBottomJoker(topJoker)

        val startOfTopSection = this.head
        val endOfTopSection = topJoker.previous

        val startOfBottomSection = bottomJoker.next
        val endOfBottomSection = this.tail


        if (startOfBottomSection == null) {
            this.head = topJoker
            topJoker.previous = null
        } else {
            this.head = startOfBottomSection
            topJoker.previous = endOfBottomSection
            endOfBottomSection.next = topJoker
        }

        if (startOfTopSection == topJoker) {
            bottomJoker.next = null
            this.tail = bottomJoker
        } else {
            bottomJoker.next = startOfTopSection
            startOfTopSection.previous = bottomJoker
            endOfTopSection?.next = null
            this.tail = endOfTopSection ?: bottomJoker
        }
    }


    private fun countCut() {
        val card = this.tail.card
        var steps = card.cardValue() - 1

        val firstItem = this.head
        var lastItemInCut = firstItem
        for (i in 1..steps) {
            lastItemInCut = lastItemInCut.next ?: throw IllegalStateException("Attempt to look past end of deck")
        }

        this.head = lastItemInCut.next ?: throw IllegalStateException("Attempt to set head past end of deck")
        this.head.previous = null

        firstItem.previous = this.tail.previous
        firstItem.previous?.next = firstItem

        this.tail.previous = lastItemInCut
        lastItemInCut.next = this.tail
    }


    private fun getOutputLetter() : String {
        val card = this.head.card
        val steps = card.cardValue()

        var item = this.head
        for (i in 1..steps) {
            item = item.next ?: throw IllegalStateException("Attempt to move past end of deck")
        }

        if (item.card is Joker) {
            return ""
        }

        val letterCard = item.card as PlayingCard
        var letterValue = letterCard.cardValue()
        if (letterValue > LETTERS_IN_ALPHABET ) {
            letterValue = letterValue - LETTERS_IN_ALPHABET
        }
        val asciiValue = letterValue + ASCII_A - 1

        return Character.toString(asciiValue.toChar())
    }
}