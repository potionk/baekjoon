package bj17103

import java.io.*
import kotlin.math.max
import kotlin.math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val t = br.readLine().toInt()
    val list = mutableListOf<Int>()
    var max = -1
    for (i in 0 until t) {
        val n = br.readLine().toInt()
        list.add(n)
        max = max(max, n)
    }
    val primeNumbers = sieveOfEratosthenes(max)
    val primeNumbersSet = primeNumbers.toSet()
    for (i in 0 until t) {
        var count = 0
        val n = list[i]
        for (j in primeNumbers.indices) {
            if (primeNumbers[j] > n / 2) {
                break
            }
            if (primeNumbersSet.contains(n - primeNumbers[j])) {
                count++
            }
        }
        bw.write("$count\n")
    }
    bw.close()
}

fun sieveOfEratosthenes(n: Int): List<Int> {
    val primes = BooleanArray(n + 1) { true }
    primes[0] = false
    primes[1] = false

    val m = sqrt(n.toDouble()).toInt()

    for (i in 2..m) {
        if (primes[i]) {
            for (k in i * i..n step i) {
                primes[k] = false
            }
        }
    }

    val primeNumbers = mutableListOf<Int>()
    for (i in 2..n) {
        if (primes[i]) {
            primeNumbers.add(i)
        }
    }

    return primeNumbers
}
