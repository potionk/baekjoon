package bj28431

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val set = mutableSetOf<Int>()
    for (i in 0 until 5) {
        val n = br.readLine().toInt()
        if (set.contains(n)) {
            set.remove(n)
        } else {
            set.add(n)
        }
    }
    print(set.sum())
}
