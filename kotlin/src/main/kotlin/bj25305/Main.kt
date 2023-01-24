package bj25305

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val nk = br.readLine().split(" ").map { it.toInt() }
    println(br.readLine().split(" ").map { it.toInt() }.sorted().reversed()[nk[1] - 1])
}
