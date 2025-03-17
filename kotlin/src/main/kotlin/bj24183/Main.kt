package bj24183

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (env, poster, info) = br.readLine().split(" ").map { it.toDouble() }

    val c4Area = 0.229 * 0.324
    val a3Area = 0.297 * 0.420
    val a4Area = 0.210 * 0.297

    println(2 * c4Area * env + 2 * a3Area * poster + a4Area * info)
}
