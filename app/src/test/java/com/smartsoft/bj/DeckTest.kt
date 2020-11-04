package com.smartsoft.bj

import com.smartsoft.bj.core.Deck
import org.junit.Assert.*
import org.junit.Test

class DeckTest {

    @Test
    fun testDeck() {
        Deck(shuffle = false).apply {
            assertEquals(52, size)
            assertEquals(0, nextCard)
        }.takeCard().apply {
            assertEquals("Ace of Spades", card.name)
            assertEquals(1, card.value)
            assertEquals(1, card.suit)
            assertEquals(0, card.index)
            assertEquals(51, deck.size)
            assertEquals(1, deck.nextCard)
        }.deck.takeCard().apply {
            assertEquals("2 of Spades", card.name)
            assertEquals(2, card.value)
            assertEquals(1, card.suit)
            assertEquals(1, card.index)
            assertEquals(50, deck.size)
            assertEquals(2, deck.nextCard)
        }.deck.takeCard().apply {
            assertEquals("3 of Spades", card.name)
            assertEquals(3, card.value)
            assertEquals(1, card.suit)
            assertEquals(2, card.index)
            assertEquals(49, deck.size)
            assertEquals(3, deck.nextCard)
        }.deck.takeCards(2).apply {
            assertEquals("4 of Spades", cards[0].name)
            assertEquals("5 of Spades", cards[1].name)
            assertEquals(3, cards[0].index)
            assertEquals(4, cards[0].value)
            assertEquals(1, cards[0].suit)
            assertEquals(4, cards[1].index)
            assertEquals(47, deck.size)
            assertEquals(5, deck.nextCard)
        }.deck.takeCards(47).apply {
            assertEquals(47, cards.size)
            val c1 = cards.first()
            val c2 = cards.last()

            assertEquals("6 of Spades", c1.name)
            assertEquals(5, c1.index)
            assertEquals(6, c1.value)
            assertEquals(1, c1.suit)

            assertEquals("King of Diamonds", c2.name)
            assertEquals(51, c2.index)
            assertEquals(13, c2.value)
            assertEquals(4, c2.suit)

            assertEquals(0, deck.size)
            assertEquals(52, deck.nextCard)
            assertTrue( deck.isEmpty)
        }
    }


}

