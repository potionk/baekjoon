package bj4134

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = br.readLine().toInt()
    for (i in 0 until n) {
        var num = br.readLine().toLong()
        if (num == 0L || num == 1L) {
            bw.write("2\n")
            continue
        } else {
            while (true) {
                if (isPrime(num)) {
                    break
                }
                num++
            }
            bw.write("$num\n")
        }
    }
    br.close()
    bw.close()
}

fun isPrime(num: Long): Boolean {
    var i = 2L
    while (i * i <= num) {
        if (num % i == 0L) return false
        i++
    }
    return true
}
