package bj15565

import java.io.*
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val (n, k) = br.readLine().split(" ").map { it.toInt() }
    val dolls = br.readLine().split(" ").map { it.toInt() }
    var start = 0
    var end = 0
    var result = Int.MAX_VALUE
    var count = 0
    for (i in dolls.indices) {
        if (dolls[i] == 1) {
            start = i
            end = i
            break
        }
    }
    while (end < n) {
        if (dolls[end] == 1) {
            count++
        }
        if (count == k) {
            while (dolls[start] != 1) {
                start++
            }
            result = min(result, end - start + 1)
            start++
            count--
        }
        end++
    }
    println(if (result == Int.MAX_VALUE) -1 else result)
}
