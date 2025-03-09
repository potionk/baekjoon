package bj26596

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val map = mutableMapOf<String, Int>()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ")
        val x = map.getOrDefault(a, 0)
        map[a] = x + b.toInt()
    }
    val values = map.values.toList()
    for (i in values.indices) {
        for (j in values.indices) {
            if (i == j) {
                continue
            }
            if ((values[i] * 1.618).toInt() == values[j]) {
                println("Delicious!")
                return
            }
        }
    }
    println("Not Delicious...")
}
