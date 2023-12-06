package bj24079

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    if(br.readLine().toDouble() + br.readLine().toDouble() <= br.readLine().toDouble() + 0.5) {
        println("1")
    } else {
        println("0")
    }
}
