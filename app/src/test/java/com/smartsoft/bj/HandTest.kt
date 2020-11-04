package com.smartsoft.bj

import com.smartsoft.bj.core.Card
import com.smartsoft.bj.core.Hand
import org.junit.Assert.assertEquals
import org.junit.Test

class HandTest {

    @Test
    fun testHand() {
        Hand(name = "Player")
                .add(Card(value = 1, suit = 1))
                .add(Card(value = 13, suit = 4))
                .apply {
                    assertEquals("Player", name)
                    assertEquals(11, points)
                    assertEquals(2, size)
                }

        Hand("Dealer")
                .add(listOf(
                    Card(value = 1, suit = 1),
                    Card(value = 2, suit = 1),
                    Card(value = 3, suit = 1)
                )
                ).apply {

                    assertEquals("Dealer", name)
                    assertEquals(6, points)
                    assertEquals(3, size)
                }


    }


}

