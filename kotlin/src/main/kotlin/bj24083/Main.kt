package bj24083

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().toInt()
    val b = br.readLine().toInt()
    println(
        ((a + b) % 12).let {
            if (it == 0) 12 else it
        }
    )
}
