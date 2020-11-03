package akw.app1.blackjack

import org.junit.Assert.assertEquals
import org.junit.Test

class GameTest {

    @Test
    fun testGame() {
        val g = Game(shuffle = false)
        assertEquals(48, g.deck.size)
        assertEquals(2, g.ph.size)
        assertEquals(2, g.dh.size)
        assertEquals(3, g.ph.points)
        assertEquals(7, g.dh.points)

        g.hit()
        assertEquals(47, g.deck.size)
        assertEquals(3, g.ph.size)
        assertEquals(2, g.dh.size)
        assertEquals(8, g.ph.points)
        assertEquals(7, g.dh.points)

        g.hit()
        assertEquals(46, g.deck.size)
        assertEquals(4, g.ph.size)
        assertEquals(2, g.dh.size)
        assertEquals(14, g.ph.points)
        assertEquals(7, g.dh.points)

        g.stay()
        assertEquals(44, g.deck.size)
        assertEquals(4, g.ph.size)
        assertEquals(4, g.dh.size)
        assertEquals(14, g.ph.points)
        assertEquals(22, g.dh.points)

        g.deal()
        assertEquals(40, g.deck.size)
        assertEquals(2, g.ph.size)
        assertEquals(2, g.dh.size)
        assertEquals(19, g.ph.points)
        assertEquals(20, g.dh.points)
    }

}