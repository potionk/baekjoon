package bj26574

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    for (i in 0 until br.readLine().toInt()) {
        println(br.readLine().plus(" ").repeat(2))
    }
    br.close()
}