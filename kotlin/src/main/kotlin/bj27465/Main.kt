package bj27465

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toLong()
    var i = n
    while (true) {
        if (!isPrime(i)) {
            println(i)
            return
        }
        i++
    }
}

fun isPrime(num: Long): Boolean {
    if (num < 2) return false
    var i = 2L
    while (i * i <= num) {
        if (num % i == 0L) return false
        i++
    }
    return true
}
