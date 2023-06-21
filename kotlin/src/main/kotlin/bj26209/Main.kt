package bj26209

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(
        if (br.readLine().split(" ").map { it.toInt() }.all { it == 0 || it == 1 }) {
            "S"
        } else {
            "F"
        }
    )
    br.close()
}
