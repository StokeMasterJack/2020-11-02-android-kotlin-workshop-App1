package com.smartsoft.bj.core

data class Card(val index: Int) {

    init {
        require(index in 0..51) { "Bad card index $index" }
    }

    constructor(value: Int, suit: Int) : this(
        computeIndex(
            value,
            suit
        )
    )

    val suit: Int get() = (index / 13) + 1
    val value: Int get() = (index % 13) + 1

    val suitName: String
        get() = when (suit) {
            1 -> "Spades"
            2 -> "Hearts"
            3 -> "Clubs"
            4 -> "Diamonds"
            else -> throw IllegalStateException()
        }

    /*
     A bug in: androidx.compose.plugins.kotlin prevents us from using WhenConditionInRange:
     val valueName get() = when (value) {
        1 -> "Ace"
        in 2..10 -> value.toString()
        11 -> "Jack"
        12 -> "Queen"
        13 -> "King"
        else -> throw IllegalStateException()
     }
    */
    @Suppress("IntroduceWhenSubject")
    val valueName
        get() = when {
            value == 1 -> "Ace"
            value in 2..10 -> value.toString()
            value == 11 -> "Jack"
            value == 12 -> "Queen"
            value == 13 -> "King"
            else -> throw IllegalStateException()
        }

    val name: String get() = "$valueName of $suitName"


    /*
     A bug in: androidx.compose.plugins.kotlin prevents us from using WhenConditionInRange:
     val points get() = when (value) {
        in 1..9 -> value
        in 10..13 -> 10
        else -> throw IllegalStateException()
     }
    */
    @Suppress("IntroduceWhenSubject")
    val points
        get() = when {
            value in 1..9 -> value
            value in 10..13 -> 10
            else -> throw IllegalStateException()
        }

    companion object {
        fun computeIndex(value: Int, suit: Int): Int {
            require(value in 1..13) { "Invalid card value: $value" }
            require(suit in 1..4) { "Invalid card suit: $suit" }
            return (suit - 1) * 13 + (value - 1)
        }
    }

    override fun toString() = name

    override fun equals(other: Any?) = other is Card && other.index == index

    override fun hashCode() = index

    fun dump() = println(this)
}

/**
 * Cannot run args-less main from within Android Studio 4.1 Canary 4 (Build #AI-193.6494.35.41.6325121)
 */
@Suppress("UnusedMainParameter")
fun main(args: Array<String>) {
    repeat(52) { Card(it).dump() }
}