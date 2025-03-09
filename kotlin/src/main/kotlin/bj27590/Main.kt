package bj27590

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (ds, ys) = br.readLine().split(" ").map { it.toInt() }
    val (dm, ym) = br.readLine().split(" ").map { it.toInt() }

    for (t in 1..5000) {
        if ((t + ds) % ys == 0 && (t + dm) % ym == 0) {
            println(t)
            return
        }
    }
}
