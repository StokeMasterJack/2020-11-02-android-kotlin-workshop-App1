package akw.app1.blackjack

class Hand(val name: String = "Player") {

    val cards: MutableList<Card> = mutableListOf()

    fun add(c: Card) {
        cards.add(c)
    }

    fun clear() {
        cards.clear()
    }

    val cardCount: Int get() = cards.size
    val size: Int get() = cardCount

    val points1: Int
        get() {
            var p = 0
            for (card in cards) {
                p += card.points
            }
            return p
        }

    val points2: Int
        get() {
            var p = 0
//            val f: (Card) -> Unit = { p += it.points }
            cards.forEach { p += it.points }
            return p
        }

    val points: Int get() = cards.sumBy { it.points }

//    val cardCount2: Int = cards.size   //wrong


}
