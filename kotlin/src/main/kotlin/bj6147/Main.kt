package bj6147

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, b) = br.readLine().split(" ").map { it.toInt() }
    val cows = mutableListOf<Int>()
    repeat(n) {
        cows.add(br.readLine().toInt())
    }
    val sortedCows = cows.sortedDescending()
    var count = 0
    var sum = 0
    for (cow in sortedCows) {
        sum += cow
        count++
        if (sum >= b) {
            break
        }
    }
    println(count)
}
