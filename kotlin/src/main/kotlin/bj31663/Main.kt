package bj31663

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val arr = IntArray(45)
    val count = IntArray(45)
    repeat(n) {
        br.readLine().toCharArray().forEachIndexed { index, c ->
            arr[index] += c.toInt()
            count[index]++
        }
    }
    for (i in 0 until 45) {
        if (count[i] == 0) break
        print("${(arr[i] / count[i]).toChar()}")
    }
}
