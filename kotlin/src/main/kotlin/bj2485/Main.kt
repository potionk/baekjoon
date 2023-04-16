package bj2485

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val trees = IntArray(n)
    for (i in 0 until n) {
        trees[i] = br.readLine().toInt()
    }
    var gcd = trees[1] - trees[0]
    for (i in 2 until n) {
        gcd = gcd(gcd, trees[i] - trees[i - 1])
    }
    var count = 0
    for (i in 0 until n - 1) {
        count += (trees[i + 1] - trees[i]) / gcd - 1
    }
    println(count)
    br.close()
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}
