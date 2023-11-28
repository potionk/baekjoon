package bj29731

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = setOf(
        "Never gonna give you up",
        "Never gonna let you down",
        "Never gonna run around and desert you",
        "Never gonna make you cry",
        "Never gonna say goodbye",
        "Never gonna tell a lie and hurt you",
        "Never gonna stop"
    )
    val n = br.readLine().toInt()
    repeat(n) {
        if (br.readLine() !in set) {
            println("Yes")
            return
        }
    }
    println("No")
}
