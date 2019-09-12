package cards

import kotlin.IllegalStateException

open class Deck {

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


    protected fun moveItemDownOne(item: Item) {
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


    protected fun findTopJoker() : Item {
        var item : Item? = this.head
        while (item != null) {
            if (item.card is Joker) {
                return item
            }
            item = item.next
        }
        throw IllegalStateException("Deck contains no jokers")
    }


    protected fun findBottomJoker(topJoker: Item) : Item {
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