package com.smartsoft.bj.core

class Hand private constructor(val name: String, val cards: List<Card>) {

    constructor(name: String) : this(name, emptyList())

    fun add(card: Card) = Hand(name, cards + card)

    fun add(cards: List<Card>) =
        Hand(name, this.cards + cards)

    fun clear(cards: List<Card>): Hand = Hand(
        name
    ).add(cards)

    val size get() = cards.size

    val points get() = cards.sumBy { it.points }
    private val p get() = points

    val msg: String
        get() = when {
            p in 1..20 -> "$p Points."
            p > 21 -> "$p Points. Bust!"
            p == 21 -> "Black Jack!"
            else -> throw IllegalStateException()
        }

    fun dump() {
        println("$name  Hand")
        cards.forEach {
            println(it.name)
        }
        println("$points  points")
    }
}