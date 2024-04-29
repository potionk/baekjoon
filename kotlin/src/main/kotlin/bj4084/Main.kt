package bj4084

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var readLine = br.readLine()
    while (readLine != "0 0 0 0") {
        var (a, b, c, d) = readLine.split(" ").map { it.toInt() }
        var count = 0
        while (a != b || b != c || c != d) {
            val tempA = a
            a = Math.abs(a - b)
            b = Math.abs(b - c)
            c = Math.abs(c - d)
            d = Math.abs(d - tempA)
            count++
        }
        println(count)
        readLine = br.readLine()
    }
}
