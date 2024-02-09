package bj6571

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.math.BigInteger

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val fibonacci = Array(481) { BigInteger.ZERO }
    fibonacci[1] = BigInteger.ONE
    fibonacci[2] = BigInteger.ONE.plus(BigInteger.ONE)
    for (i in 3..480) {
        fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2]
    }
    while (true) {
        val (a, b) = br.readLine().split(" ").map { BigInteger(it) }
        if (a == BigInteger.ZERO && b == BigInteger.ZERO) {
            break
        }
        var count = 0
        for (i in 1..480) {
            if (fibonacci[i] >= a && fibonacci[i] <= b) {
                count++
            }
        }
        bw.write("$count\n")
    }
    bw.close()
}
