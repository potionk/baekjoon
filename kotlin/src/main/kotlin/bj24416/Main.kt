package bj24416

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    bw.write("${fibonacci(n)} ${n - 2}")
    br.close()
    bw.close()
}

fun fibonacci(n: Int): Int {
    val fibonacci = IntArray(n + 1)
    fibonacci[0] = 0
    fibonacci[1] = 1
    for (i in 2..n) {
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]
    }
    return fibonacci[n]
}
