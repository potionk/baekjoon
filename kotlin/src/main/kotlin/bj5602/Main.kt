package bj5602

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    val array = IntArray(m)
    for (i in 0 until n) {
        val list = br.readLine().split(" ").map { it.toInt() }
        list.forEachIndexed { index, value ->
            array[index] += value
        }
    }
    array.mapIndexed { index, i -> Pair(index + 1, i) }
        .sortedByDescending { it.second }
        .forEach { print("${it.first} ") }
}
