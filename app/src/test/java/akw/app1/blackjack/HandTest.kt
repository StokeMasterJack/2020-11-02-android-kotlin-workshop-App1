package akw.app1.blackjack

import org.junit.Assert.assertEquals
import org.junit.Assert.fail
import org.junit.Test

//val cards:MutableList =

class HandTest {

    @Test
    fun testHand() {

        val h1 = Hand(name = "Player")

        assertEquals("Player", h1.name)
        assertEquals(0, h1.cardCount)
        assertEquals(0, h1.points)

        h1.add(Card(suit = 1,value = 1))
        h1.add(Card(suit = 1,value = 2))
        h1.add(Card(suit = 1,value = 13))

        assertEquals(3, h1.cardCount)
        assertEquals(13, h1.points)

        h1.cards.forEach {
            println(it)
        }


    }


}