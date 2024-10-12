package bj32278

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val numStr = br.readLine()
    try {
        numStr.toShort()
        println("short")
    } catch (_: NumberFormatException) {
        try {
            numStr.toInt()
            println("int")
        } catch (_: NumberFormatException) {
            println("long long")
        }
    }
}
