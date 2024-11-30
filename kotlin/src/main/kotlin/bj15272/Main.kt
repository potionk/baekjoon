package bj15272

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(if (br.readLine().contains("ss")) "hiss" else "no hiss")
}
