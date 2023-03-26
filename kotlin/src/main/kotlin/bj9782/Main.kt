package bj9782

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var count = 1
    while (true) {
        val readLine = br.readLine()
        if (readLine == "0") {
            break
        }
        val info = readLine.trim().split(" ").map { it.toInt() }
        val n = info[0]
        if (n % 2 == 0) {
            println("Case ${count}: ${(info[n / 2] + info[n / 2 + 1]) / 2.0}")
        } else {
            println("Case ${count}: ${info[(n + 1) / 2].toDouble()}")
        }
        count++
    }
    br.close()
}
