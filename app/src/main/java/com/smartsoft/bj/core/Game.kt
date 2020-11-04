@file:Suppress("FunctionName")

package com.smartsoft.bj.core

private const val ReshuffleLimit = 30

class Game private constructor(val deck: Deck, val ph: Hand, val dh: Hand, val isStay: Boolean) {

    constructor(shuffle: Boolean) : this(
        deck = Deck(shuffle),
        ph = Hand("Player"),
        dh = Hand("Dealer"),
        isStay = false
    )

    private fun cp(
        deck: Deck = this.deck,
        ph: Hand = this.ph,
        dh: Hand = this.dh,
        isStay: Boolean = this.isStay
    ) = Game(deck, ph, dh, isStay)

    fun hit(): Game {
        return if (!isGameOver) {
            val (deck, card) = deck.takeCard()
            cp(deck = deck, ph = ph.add(card))
        } else {
            this
        }
    }

    fun stay(): Game {
        return if (!isGameOver) {
            var deck = deck
            var dh = dh
            while (dh.points < 17) {
                val (d, card) = deck.takeCard()
                deck = d
                dh = dh.add(card)
            }
            cp(deck = deck, dh = dh, isStay = true)
        } else {
            this
        }
    }

    fun deal(): Game {
        val (deck, cards) = deck.maybeReset(ReshuffleLimit).takeCards(4)
        val ph = ph.clear(cards.slice(0..1))
        val dh = dh.clear(cards.slice(2..3))
        return cp(deck = deck, ph = ph, dh = dh, isStay = false)
    }

    val isGameOver: Boolean get() = isStay || ph.points >= 21

    val msg: String
        get() = if (isGameOver) {
            when {
                ph.points > 21 -> dealerWins
                dh.points > 21 -> playerWins
                ph.points == dh.points -> dealerWins
                ph.points > dh.points -> playerWins
                dh.points > ph.points -> dealerWins
                else -> throw IllegalStateException()
            }
        } else {
            pressHitOrStay
        }


    companion object {
        const val pressHitOrStay = "Press Hit or Stay"
        const val dealerWins = "Dealer Wins!"
        const val playerWins = "Player Wins!"

        fun mk(shuffle: Boolean = true): Game = Game(shuffle = shuffle).deal()

    }
}
