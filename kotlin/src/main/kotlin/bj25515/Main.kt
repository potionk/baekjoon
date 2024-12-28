package bj25515

import java.io.*
import kotlin.collections.HashMap

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val tree = HashMap<Int, MutableList<Int>>()
    repeat(n - 1) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        tree[a] = tree.getOrDefault(a, mutableListOf()).apply { add(b) }
    }
    val values = br.readLine().split(" ").map { it.toInt() }
    val sumResult = LongArray(n)

    fun dfs(node: Int): Long {
        if (sumResult[node] != 0L) {
            return sumResult[node]
        }
        var sum = 0L
        tree[node]?.forEach {
            val itSum = dfs(it)
            if (itSum > 0) {
                sum += itSum
            }
        }
        sumResult[node] = sum + values[node]
        return sumResult[node]
    }
    println(dfs(0))
}
