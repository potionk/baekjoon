package bj2961

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val ingredients = mutableListOf<Pair<Int, Int>>()
    for (i in 0 until n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        ingredients.add(Pair(a, b))
    }
    fun dfs(idx: Int, sour: Int, bitter: Int): Int {
        if (idx == n) {
            return if (sour == 1 && bitter == 0) {
                Int.MAX_VALUE
            } else {
                abs(sour - bitter)
            }
        }
        val ingredient = ingredients[idx]
        return min(dfs(idx + 1, sour * ingredient.first, bitter + ingredient.second), dfs(idx + 1, sour, bitter))
    }
    println(dfs(0, 1, 0))
}
