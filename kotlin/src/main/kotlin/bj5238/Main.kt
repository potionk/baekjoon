package bj5238

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().trim().toInt()
    fun isFibonacciSequence(list: List<Long>): Boolean {
        for (i in 2 until list.size) {
            if (list[i] != list[i - 1] + list[i - 2]) {
                return false
            }
        }
        return true
    }
    repeat(n) {
        val list = br.readLine().trim().split(" ").map { it.toLong() }
        if (isFibonacciSequence(list.drop(1))) {
            println("YES")
        } else {
            println("NO")
        }
    }
}
