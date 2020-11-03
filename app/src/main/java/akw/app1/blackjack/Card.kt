package akw.app1.blackjack

class Card(val suit: Int, val value: Int) {

    init {
        require(suit in 1..4)
        require(value in 1..13)
    }

    fun suitName1(): String {
        return when (suit) {
            1 -> "Spades"
            2 -> "Hearts"
            3 -> "Clubs"
            4 -> "Diamonds"
            else -> throw IllegalStateException("Bad suit: $suit")
        }
    }

    val suitName: String
        get() {
            return when (suit) {
                1 -> "Spades"
                2 -> "Hearts"
                3 -> "Clubs"
                4 -> "Diamonds"
                else -> throw IllegalStateException("Bad suit: $suit")
            }
        }


    val valueName: String
        get() {
            return when (value) {
                1 -> "Ace"  //1
                in 2..10 -> value.toString()    //same as value
                11 -> "Jack"    //10
                12 -> "Queen"   //10
                13 -> "King"    //10
                else -> throw IllegalStateException("Bad value: $value")
            }
        }

    val name: String get() = "$valueName of $suitName"

    override fun toString(): String = name

    val points: Int
        get() {
            return when (value) {
                in 1..10 -> value
                in 11..13 -> 10
                else -> throw IllegalStateException("Bad value: $value")
            }
        }

    /*
    1. finish valueName
    2. create (and test) a points getter  (see valueName) ace = 1
     */

    /*

    val x = 3 > 2? "a" : "b"
    val y = if(3 > 2) "a" else "b"


     */


}