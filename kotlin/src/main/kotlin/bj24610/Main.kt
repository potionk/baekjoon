package bj24610

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var (n, m) = br.readLine().split(" ").map { it.toInt() }
    val result = IntArray(m)
    val teams = IntArray(m) { br.readLine().toInt() }
    var round = 0
    while (n > 0) {
        var accepted = false
        for (i in 0 until m) {
            if (teams[i] > round && n > 0) {
                result[i]++
                n--
                accepted = true
            }
        }
        if (!accepted) break
        round++
    }
    for (i in 0 until m) {
        println(result[i])
    }
}