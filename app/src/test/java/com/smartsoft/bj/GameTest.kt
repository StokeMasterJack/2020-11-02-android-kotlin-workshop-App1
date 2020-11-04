package com.smartsoft.bj

import com.smartsoft.bj.core.Game
import org.junit.Assert.*
import org.junit.Test

class GameTest {

    @Test
    fun testGame() {

        val g1 = Game(shuffle = true)
        val g2 = g1.hit()
        Game.mk(shuffle = false).apply {
            //ph: 1 2
            //dh: 3 4
            assertEquals(48, deck.size)
            assertEquals(2, ph.size)
            assertEquals(2, dh.size)
            assertEquals(3, ph.points)
            assertEquals(7, dh.points)
            assertFalse(isStay)
            assertFalse(isGameOver)
            assertEquals(Game.pressHitOrStay, msg)
        }.hit().apply {
            //ph: 1 2 5
            //dh: 3 4
            assertEquals(47, deck.size)
            assertEquals(3, ph.size)
            assertEquals(2, dh.size)
            assertEquals(8, ph.points)
            assertEquals(7, dh.points)
            assertFalse(isStay)
            assertFalse(isGameOver)
            assertEquals(Game.pressHitOrStay, msg)
        }.hit().apply {
            //ph: 1 2 5 6
            //dh: 3 4
            assertEquals(46, deck.size)
            assertEquals(4, ph.size)
            assertEquals(2, dh.size)
            assertEquals(14, ph.points)
            assertEquals(7, dh.points)
            assertFalse(isStay)
            assertFalse(isGameOver)
            assertEquals(Game.pressHitOrStay, msg)
        }.stay().apply {
            ph.dump()
            dh.dump()
            //ph: 1 2 5 6
            //dh: 3 4 7 8
            assertEquals(44, deck.size)
            assertEquals(4, ph.size)
            assertEquals(4, dh.size)
            assertEquals(14, ph.points)
            assertEquals(22, dh.points)
            assertTrue(isStay)
            assertTrue(isGameOver)
            assertEquals(Game.playerWins, msg)
        }.deal().apply {
            //ph: 9 10
            //dh: j10 q10

            assertEquals(40, deck.size)
            assertEquals(2, ph.size)
            assertEquals(2, dh.size)
            assertEquals(19, ph.points)
            assertEquals(20, dh.points)
            assertFalse(isStay)
            assertFalse(isGameOver)
            assertEquals(Game.pressHitOrStay, msg)

        }.apply {

            hit().apply {

                //ph: 9 10 k10
                //dh: j10 q10

                assertEquals(39, deck.size)
                assertEquals(3, ph.size)
                assertEquals(2, dh.size)
                assertEquals(29, ph.points)
                assertEquals(20, dh.points)
                assertFalse(isStay)
                assertTrue(isGameOver)
                assertEquals(Game.dealerWins, msg)
            }

            stay().apply {

                //ph: 9 10
                //dh: j10 q10

                assertEquals(40, deck.size)
                assertEquals(2, ph.size)
                assertEquals(2, dh.size)
                assertEquals(19, ph.points)
                assertEquals(20, dh.points)
                assertTrue(isStay)
                assertTrue(isGameOver)
                assertEquals(Game.dealerWins, msg)
            }

        }

    }


}

