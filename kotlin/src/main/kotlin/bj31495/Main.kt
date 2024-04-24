package bj31495

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    if (str.first() == '"' && str.last() == '"') {
        if (str.length < 2) {
            println("CE")
        } else {
            val s = str.subSequence(1, str.length - 1)
            if (s.trim().isEmpty()) {
                println("CE")
            } else {
                println(s)
            }
        }
    } else {
        println("CE")
    }
}
