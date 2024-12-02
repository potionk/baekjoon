package bj8117

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val list = mutableListOf<Int>()
    while (true) {
        val n = br.readLine().toInt()
        if (n == 0) break
        list.add(n)
    }
    list.sort()
    for (i in 0 until list.size - 2) {
        if (list[i] + list[i + 1] > list[i + 2]) {
            println("${list[i]} ${list[i + 1]} ${list[i + 2]}")
            return
        }
    }
    println("NIE")
}
