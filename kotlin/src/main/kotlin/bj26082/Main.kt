package bj26082

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val abc = br.readLine().split(" ").map { it.toInt() }
    println(abc[1] / abc[0] * abc[2] * 3)
    br.close()
}
