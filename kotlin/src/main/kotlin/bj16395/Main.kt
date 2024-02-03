package bj16395

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    println(
        if (k == 1 || k == n) 1
        else {
            val pascal = Array(n) { IntArray(n) }
            pascal[0][0] = 1
            pascal[1][0] = 1
            pascal[1][1] = 1
            for (i in 2 until n) {
                pascal[i][0] = 1
                pascal[i][i] = 1
                for (j in 1 until i) {
                    pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j]
                }
            }
            pascal[n - 1][k - 1]
        }
    )
}
