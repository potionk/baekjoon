package bj32154

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    println(
        when (n) {
            1 -> {
                "11\nA B C D E F G H J L M"
            }

            2, 3 -> {
                "9\nA C E F G H I L M"
            }

            4 -> {
                "9\nA B C E F G H L M"
            }

            5, 6, 7, 8, 9 -> {
                "8\nA C E F G H L M"
            }

            else -> {
                "8\nA B C F G H L M"
            }
        }
    )
}
