package bj12891

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (s, p) = br.readLine().split(" ").map { it.toInt() }
    val dna = br.readLine().toCharArray()
    val acgt = br.readLine().split(" ").map { it.toInt() }
    val count = IntArray(4)
    for (i in 0 until p) {
        when (dna[i]) {
            'A' -> count[0]++
            'C' -> count[1]++
            'G' -> count[2]++
            'T' -> count[3]++
        }
    }
    var result = if (validate(count, acgt)) 1 else 0
    for (i in 1 until s - p + 1) {
        when (dna[i - 1]) {
            'A' -> count[0]--
            'C' -> count[1]--
            'G' -> count[2]--
            'T' -> count[3]--
        }
        when (dna[i + p - 1]) {
            'A' -> count[0]++
            'C' -> count[1]++
            'G' -> count[2]++
            'T' -> count[3]++
        }
        if (validate(count, acgt)) {
            result++
        }
    }
    println(result)
}

fun validate(count: IntArray, acgt: List<Int>): Boolean {
    for (i in 0 until 4) {
        if (count[i] < acgt[i]) {
            return false
        }
    }
    return true
}
