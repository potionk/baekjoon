package bj10347

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val order = "ABCDEFGHIJKLMNOPQRSTUVWXYZ_.".toCharArray()
    while (true) {
        val readLine = br.readLine().trim()
        if (readLine == "0") {
            break
        }
        val (n, str) = readLine.split(" ")
        val rotated = rotate(order, n.toInt())
        println(str.reversed().map { rotated[it] }.joinToString(""))
    }
}

fun rotate(arr: CharArray, n: Int): Map<Char, Char> {
    return arr.mapIndexed { index, c -> arr[(index - n + arr.size) % arr.size] to c }.toMap()
}
