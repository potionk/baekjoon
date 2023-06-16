package bj8371

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val input1 = br.readLine().toCharArray()
    val input2 = br.readLine().toCharArray()
    var count = 0
    for (i in 0 until n) {
        if (input1[i] != input2[i]) {
            count++
        }
    }
    println(count)
    br.close()
}
