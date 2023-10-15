package bj15098

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val words = br.readLine().split(" ")
    if (words.size == words.toSet().size) {
        println("yes")
    } else {
        println("no")
    }
}
