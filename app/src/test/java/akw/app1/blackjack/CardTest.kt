package akw.app1.blackjack

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

class CardTest {

    @Test
    fun testCard() {
        val c1 = Card(suit = 1, value =1)    //Ace of Spades
        val c2 = Card(suit = 4, value =13)   //King of Diamonds

        assertEquals(1, c1.suit)
        assertEquals(1, c1.value)
        assertEquals("Spades", c1.suitName)
        assertEquals("Ace", c1.valueName)
        assertEquals(1, c1.points)

        assertEquals(4, c2.suit)
        assertEquals(13, c2.value)
        assertEquals("Diamonds", c2.suitName)
        assertEquals("King", c2.valueName)
        assertEquals(10, c2.points)

    }

    @Test
    fun testInit() {
        try {
            Card(suit = 33, value = 2)
            fail()
        } catch (e: IllegalArgumentException) {
            //ok
        }
    }

}