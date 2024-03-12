package bj9946

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var case = 1
    while (true) {
        val a = br.readLine()
        val b = br.readLine()
        if (a == "END" && b == "END") {
            break
        }
        val aMap = a.groupingBy { it }.eachCount()
        val bMap = b.groupingBy { it }.eachCount()
        println(
            if (aMap == bMap) {
                "Case ${case++}: same"
            } else {
                "Case ${case++}: different"
            }
        )
    }
}
