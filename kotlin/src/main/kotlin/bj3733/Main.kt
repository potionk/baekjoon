package bj3733

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var readLine = br.readLine()
    while (readLine != null) {
        val ns = readLine.split(" ").map { it.toInt() }
        println(ns[1] / (ns[0] + 1))
        readLine = br.readLine()
    }
    br.close()
}
