package bj2721

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    repeat(n) {
        bw.write("${W(br.readLine().toInt())}\n")
    }
    bw.close()
}

fun T(n: Int): Int {
    return n * (n + 1) / 2
}

fun W(n: Int): Int {
    var sum = 0
    for (k in 1..n) {
        sum += k * T(k + 1)
    }
    return sum
}
