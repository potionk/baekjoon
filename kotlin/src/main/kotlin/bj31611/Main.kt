package bj31611

import java.io.*
fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(
        if(br.readLine().toInt() % 7 == 2) 1 else 0
    )
}