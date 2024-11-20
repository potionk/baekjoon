package bj30822

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val charArray = br.readLine().toCharArray()
    var uCount = 0
    var oCount = 0
    var sCount = 0
    var pCount = 0
    var cCount = 0
    charArray.forEachIndexed { index, c ->
        when (c) {
            'u' -> uCount++
            'o' -> oCount++
            's' -> sCount++
            'p' -> pCount++
            'c' -> cCount++
        }
    }
    println(minOf(uCount, oCount, sCount, pCount, cCount))
}
