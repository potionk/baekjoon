package bj33654

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine().split(" ").map { it.toInt() }
    val result = mutableListOf<Int>()
    var max = Int.MIN_VALUE
    for (num in a) {
        if (num >= max) {
            result.add(num)
            max = num
        }
    }
    println(result.joinToString(" "))
}
