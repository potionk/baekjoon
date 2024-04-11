package bj10205

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val k = br.readLine().toInt()
    repeat(k) {
        val h = br.readLine().toInt()
        val s = br.readLine()
        println("Data Set ${it + 1}:")
        println(calRemainHeads(h, s))
        println()
    }
}

fun calRemainHeads(h: Int, s: String): Int {
    var remainHeads = h
    for (i in s.indices) {
        if (s[i] == 'c') {
            remainHeads++
        } else {
            remainHeads--
        }
    }
    return remainHeads
}