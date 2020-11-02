package akw.app1

fun f1() {
    println("hello")

    val b1 = Box(10,10)
    println(b1)
    println(b1.height)
    println(b1.width)
    println(b1)

    val b2 = Box2(10,10)
    println(b2)
    println(b2.height)
    println(b2.width)
    println(b2)



}


data class Box(var width:Int,var height:Int)

fun main() {
    f1()
}