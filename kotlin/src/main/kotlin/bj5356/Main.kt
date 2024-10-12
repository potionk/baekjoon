package bj5356

import java.io.*

val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray()

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (num, char) = br.readLine().split(" ")
        printTriangle(num.toInt(), char[0] - 'A')
    }
}

fun printTriangle(num: Int, charIdx: Int) {
    var idx = charIdx
    for (i in 0 until num) {
        for (j in 0 until i + 1) {
            print(alphabet[idx])
        }
        idx = (idx + 1) % 26
        println()
    }
    println()
}
