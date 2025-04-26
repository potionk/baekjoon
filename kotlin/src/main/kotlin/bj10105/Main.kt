package bj10105

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()
    val firstList = br.readLine().split(" ")
    val secondList = br.readLine().split(" ")

    val pairMap = mutableMapOf<String, String>()
    for (i in 0 until n) {
        val a = firstList[i]
        val b = secondList[i]
        if (a == b) {
            println("bad")
            return
        }
        pairMap[a] = b
    }
    for ((a, b) in pairMap) {
        if (pairMap[b] != a) {
            println("bad")
            return
        }
    }
    println("good")
}
