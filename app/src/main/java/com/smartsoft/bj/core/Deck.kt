package com.smartsoft.bj.core

import com.smartsoft.util.shuffledIf

data class DeckCard(val deck: Deck, val card: Card)
data class DeckCards(val deck: Deck, val cards: List<Card>)

private const val d52 = 52

private fun mkCards(shuffle: Boolean) = List(d52, ::Card).shuffledIf(shuffle)


//nextCard=52 means deck is empty
class Deck private constructor(
    private val allCards: List<Card>,
    internal val nextCard: Int,
    private val shuffle: Boolean = true
) {

    init {
        require(allCards.size == d52)
        require(nextCard in 0..d52)
    }

    constructor(shuffle: Boolean = true) : this(
        allCards = mkCards(shuffle),
        nextCard = 0,
        shuffle = shuffle
    )

    private fun cp(
        cards: List<Card> = this.allCards,
        nextCard: Int = this.nextCard,
        shuffle: Boolean = this.shuffle
    ) = Deck(cards, nextCard, shuffle)

    val size get() = d52 - nextCard

    val isEmpty: Boolean get() = nextCard == d52

    private val cards: List<Card>
        get() = allCards.subList(
            nextCard,
            d52
        )

    fun takeCard(): DeckCard = takeCards(1).let {
        check(it.cards.size == 1)
        DeckCard(it.deck, it.cards[0])
    }

    fun takeCards(n: Int): DeckCards =
        DeckCards(
            cp(nextCard = this.nextCard + n),
            allCards.subList(this.nextCard, this.nextCard + n)
        )

    fun maybeReset(min: Int): Deck = if (size < min) reset() else this

    private fun reset(): Deck =
        Deck(shuffle = shuffle)

    fun dump() {
        cards.forEach(Card::dump)
    }


}

/**
 * Cannot run args-less main from within Android Studio 4.1 Canary 4 (Build #AI-193.6494.35.41.6325121)
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    Deck(shuffle = false).dump()
}
