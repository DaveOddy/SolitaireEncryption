package cards

import kotlin.IllegalStateException

class Deck {

    companion object {

        private val LETTERS_IN_ALPHABET = 26

        private val ASCII_A = 65
    }

    constructor(loader: DeckLoader) {
        var card = loader.requestCard()
        if (card == null) {
            throw IllegalStateException("No cards provided")
        }

        var lastItem: Item? = null

        while (card != null) {

            val item = Item(card, lastItem, null)
            lastItem?.next = item
            lastItem = item

            if (!::head.isInitialized) {
                this.head = item
            }

            if (card is Joker) {
                if (!::jokerA.isInitialized) {
                    this.jokerA = item
                } else if (!::jokerB.isInitialized) {
                    this.jokerB = item
                } else {
                    throw IllegalStateException("Only two jokers are allowed")
                }
            }

            card = loader.requestCard()
        }

        this.tail = lastItem ?: throw IllegalStateException("Tail item not set")

        if (!::jokerA.isInitialized) {
            throw IllegalStateException("No jokers provided")
        }
        if (!::jokerB.isInitialized) {
            throw IllegalStateException("Only one joker provided")
        }
    }

    lateinit var head: Item
    var tail: Item

    lateinit var jokerA: Item
    lateinit var jokerB: Item


    private fun moveJokerA() {
        moveItemDownOne(this.jokerA)
    }


    private fun moveJokerB() {
        moveItemDownOne(this.jokerB)
        moveItemDownOne(this.jokerB)
    }


    private fun moveItemDownOne(item: Item) {

        if (item.next == null) {
            wrapItem(item)
        } else {
            shiftItem(item)
        }
    }


    private fun wrapItem(item: Item) {
        item.previous?.next = null
        this.tail = item.previous ?: throw IllegalStateException("Attempt to set invalid tail")

        item.previous = this.head
        item.next = this.head.next

        this.head.next = item
        item.next?.previous = item
    }


    private fun shiftItem(item: Item) {
        val shiftPartners = getShiftPartners(item)
        setNewHeadWhenShiftFromHead(shiftPartners)
        realignListForShift(item, shiftPartners)
        resetTailWhenShiftedToTail(item)
    }


    private fun getShiftPartners(item: Item) : ShiftPartners {
        return ShiftPartners(item.previous, item.next, item.next?.next)
    }


    private fun setNewHeadWhenShiftFromHead(shiftPartners: ShiftPartners) {
        if (shiftPartners.oldPrevious == null) {
            this.head = shiftPartners.oldNextNewPrevious ?: throw IllegalStateException("Invalid head state")
        }
    }


    private fun realignListForShift(item: Item, shiftPartners: ShiftPartners) {
        shiftPartners.oldPrevious?.next = shiftPartners.oldNextNewPrevious
        shiftPartners.oldNextNewPrevious?.previous = shiftPartners.oldPrevious
        shiftPartners.oldNextNewPrevious?.next= item
        shiftPartners.newNext?.previous = item

        item.previous = shiftPartners.oldNextNewPrevious
        item.next = shiftPartners.newNext
    }


    private fun resetTailWhenShiftedToTail(item: Item) {
        if (item.next == null) {
            this.tail = item
        }
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


    private fun findTopJoker() : Item {
        var item : Item? = this.head
        while (item != null) {
            if (item.card is Joker) {
                return item
            }
            item = item.next
        }
        throw IllegalStateException("Deck contains no jokers")
    }


    private fun findBottomJoker(topJoker: Item) : Item {
        if (topJoker == this.jokerA) {
            return this.jokerB
        } else {
            return this.jokerA
        }
    }


    data class Item(val card: Card, var previous: Item?, var next: Item?)
    data class ShiftPartners(val oldPrevious: Item?, val oldNextNewPrevious: Item?, val newNext: Item?)

    interface DeckLoader {
        fun requestCard() : Card?
    }
}