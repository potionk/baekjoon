package bj10384

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val s = br.readLine()
        val count = IntArray(26)
        for (c in s) {
            if (c.isLetter()) {
                count[c.lowercaseChar() - 'a']++
            }
        }
        val min = count.minOrNull() ?: 0
        println(
            "Case ${it + 1}: ${
                when (min) {
                    0 -> "Not a pangram"
                    1 -> "Pangram!"
                    2 -> "Double pangram!!"
                    else -> "Triple pangram!!!"
                }
            }"
        )
    }
}
