package bj11558

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val t = br.readLine().toInt()
    repeat(t) {
        val n = br.readLine().toInt()
        val arr = IntArray(n + 1)
        for (i in 1..n) {
            arr[i] = br.readLine().toInt()
        }
        var count = 0
        var cur = 1
        while (true) {
            if (cur == n) {
                break
            }
            if (count > n) {
                count = 0
                break
            }
            cur = arr[cur]
            count++
        }
        println(count)
    }
}
