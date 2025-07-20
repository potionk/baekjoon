package bj34071

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val list = mutableListOf<Int>()
    for (i in 1..n) {
        list.add(br.readLine().toInt())
    }
    if (list.maxOrNull()!! == list[0])
        println("hard")
    else if (list.minOrNull()!! == list[0])
        println("ez")
    else
        println("?")
}
