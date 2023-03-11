package bj26711

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(br.readLine().toBigInteger().plus(br.readLine().toBigInteger()))
    br.close()
}
