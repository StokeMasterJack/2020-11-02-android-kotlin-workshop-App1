package akw.app1.blackjack

class Game(val shuffle: Boolean = true) {

    var deck = Deck(shuffle)
    val ph = Hand("Player")
    val dh = Hand("Dealer")
    var _stay: Boolean = false

    init {
        deal()
    }

    fun hit() {
        hitInternal(ph)
    }

    fun stay() {
        _stay = true
        while (dh.points < 17) hitInternal(dh)
    }

    private fun hitInternal(h: Hand) {
        h.add(deck.take())
    }

    fun deal() {
        _stay = false
        if (deck.size < 30) deck = Deck(shuffle)
        ph.clear()
        dh.clear()
        hitInternal(ph)
        hitInternal(ph)
        hitInternal(dh)
        hitInternal(dh)
    }

    val isGameOver: Boolean get() = _stay || ph.points > 21

    val isActive: Boolean get() = !isGameOver

    val msg: String
        get() = if (isGameOver) {
            if (ph.points > 21) "Dealer Wins!"
            else if (dh.points > 21) "Player Wins!"
            else if (ph.points == dh.points) "Tie"
            else if (ph.points > dh.points) "Player Wins!"
            else if (dh.points > ph.points) "Dealer Wins!"
            else throw IllegalStateException()
        } else {
            "Press Hit or Stay"
        }

}