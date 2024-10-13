package bj20376

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var readLine = br.readLine()
    val set = mutableSetOf<String>()
    while (readLine != null) {
        val monument = readLine.substring(11)
        set.add(monument)
        readLine = br.readLine()
    }
    println(set.size)
}
