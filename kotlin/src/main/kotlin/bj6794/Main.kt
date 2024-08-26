package bj6794

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    println(
            when (n) {
                1 -> 1
                2 -> 2
                3 -> 2 // 3, 2 1
                4 -> 3 // 4, 2 2, 3 1
                5 -> 3 // 5, 3 2, 4 1
                6 -> 3 // 5 1, 4 2, 3 3
                7 -> 2 // 5 2, 4 3
                8 -> 2
                9 -> 1
                else -> 1
            }
    )
}
