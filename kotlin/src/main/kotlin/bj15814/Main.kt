package bj15814

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val strArray = br.readLine().toCharArray()
    val n = br.readLine().toInt()
    repeat(n) {
        val (i, j) = br.readLine().split(" ").map { it.toInt() }
        val temp = strArray[i]
        strArray[i] = strArray[j]
        strArray[j] = temp
    }
    println(strArray)
}
