package bj31867

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine()
    val k = br.readLine()
    var oddCount = 0
    var evenCount = 0
    k.forEach { c ->
        if ((c - '0') % 2 == 0) {
            evenCount++
        } else {
            oddCount++
        }
    }
    println(if (oddCount > evenCount) "1" else if (oddCount < evenCount) "0" else "-1")
}
