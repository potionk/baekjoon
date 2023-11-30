package bj27257

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var k = br.readLine()
    while(k.first() == '0') {
        k = k.drop(1)
    }
    while (k.last() == '0') {
        k = k.dropLast(1)
    }
    println(k.count { it == '0' })
}
