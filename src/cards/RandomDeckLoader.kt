package cards

class RandomDeckLoader : UnKeyedDeckLoader() {

    override fun getCardList(): List<Card> {
        return super.getCardList().shuffled()
    }
}