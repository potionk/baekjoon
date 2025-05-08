package bj17389

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val charArray = br.readLine().toCharArray()
    var bonus = 0
    var score = 0
    for(i in 0 until n) {
        if(charArray[i] == 'O') {
            score += bonus
            score += i+1
            bonus++
        } else {
            bonus = 0
        }
    }
    println(score)
}