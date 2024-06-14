package bj18706

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val (c, p) = br.readLine().split(" ").map { it.toInt() }
        val menu = mutableMapOf<String, Triple<Int, Int, Int>>()
        repeat(c) {
            val (type, s, m, l) = br.readLine().split(" ")
            menu[type] = Triple(s.toInt(), m.toInt(), l.toInt())
        }
        repeat(p) {
            val (name, size, type) = br.readLine().split(" ")
            val (s, m, l) = menu[type]!!
            val price = when (size) {
                "small" -> s
                "medium" -> m
                "large" -> l
                else -> 0
            }
            val delivery = 100 / p
            val result = price + delivery
            if (result % 5 == 1) println("$name ${result - 1}")
            else if (result % 5 == 4) println("$name ${result + 1}")
            else println("$name ${price + delivery}")
        }
    }
}
