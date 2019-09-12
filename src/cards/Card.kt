package cards

abstract class Card {
    abstract fun cardValue(): Int
    abstract fun letterValue() : String
}