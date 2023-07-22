package bj18110

import java.io.*
import kotlin.math.roundToInt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val score = mutableListOf<Int>()
    for (i in 0 until n) {
        score.add(br.readLine().toInt())
    }
    if (n == 0) {
        println(0)
        return
    }
    val cut = (n * 15.0 / 100).roundToInt()
    score.sorted().subList(cut, n - cut).average().let { println(it.roundToInt()) }
}
