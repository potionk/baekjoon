package bj31243

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = mutableListOf<Int>()
    repeat(3) {
        val (aHour, aMin, bHour, bMin) = br.readLine().trim().split(" ").map { it.toInt() }
        val a = aHour * 60 + aMin
        val b = bHour * 60 + bMin
        if (b - a < 0) {
            list.add(1440 + b - a)
        } else {
            list.add(b - a)
        }
    }
    val min = list.min()
    println("${min / 60}:${fillZero(min % 60)}")
    val max = list.max()
    println("${max / 60}:${fillZero(max % 60)}")
}

fun fillZero(n: Int): String {
    return if (n < 10) {
        "0$n"
    } else {
        "$n"
    }
}
