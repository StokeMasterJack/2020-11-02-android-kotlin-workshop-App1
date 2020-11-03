package akw.app1.blackjack

import org.junit.Assert.assertEquals
import org.junit.Test

class DeckTest {

    @Test
    fun testDeck() {
        val d1 = Deck(shuffle = false)
        assertEquals(52, d1.size)

        val c1 = d1.take()
        assertEquals("Ace of Spades", c1.name)
        assertEquals(51, d1.size)

        val c2 = d1.take()
        assertEquals("2 of Spades", c2.name)
        assertEquals(50, d1.size)

        println()

        renderDeck(d1)

    }

    private fun renderDeck(d1: Deck) {
        d1.cards.forEach { println(it.name) }
    }


}