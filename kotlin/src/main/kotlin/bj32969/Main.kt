package bj32969

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    if (str.contains("social") || str.contains("history") || str.contains("language") || str.contains("literacy")) {
        println("digital humanities")
    } else {
        println("public bigdata")
    }
}
