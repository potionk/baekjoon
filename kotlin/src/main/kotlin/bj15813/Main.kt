package bj15813

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    br.readLine()
    var sum = 0
    br.readLine().toCharArray().forEach { sum += it - 'A' + 1 }
    print("$sum")
}
