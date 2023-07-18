package bj28113

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, a, b) = br.readLine().split(" ").map { it.toInt() }
    println(
        if (a < b) {
            "Bus"
        } else if (a > b) {
            "Subway"
        } else {
            "Anything"
        }
    )
    br.close()
}
