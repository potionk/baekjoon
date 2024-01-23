package bj2702

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val gcd = gcd(a, b)
        val lcm = a * b / gcd
        println("$lcm $gcd")
    }
}

fun gcd(a: Int, b: Int): Int {
    var x = a
    var y = b
    while (y != 0) {
        val r = x % y
        x = y
        y = r
    }
    return x
}
