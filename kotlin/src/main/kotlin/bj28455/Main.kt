package bj28455

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val mapleCharacters = Array(n) { 0 }
    for (i in 0 until n) {
        mapleCharacters[i] = br.readLine().toInt()
    }
    val sortedCharacters = mapleCharacters.sortedArrayDescending()
    var total = 0
    var effect = 0
    for (i in 0 until min(n, 42)) {
        total += sortedCharacters[i]
        if (sortedCharacters[i] >= 250) {
            effect += 5
        } else if (sortedCharacters[i] >= 200) {
            effect += 4
        } else if (sortedCharacters[i] >= 140) {
            effect += 3
        } else if (sortedCharacters[i] >= 100) {
            effect += 2
        } else if (sortedCharacters[i] >= 60) {
            effect += 1
        }
    }
    println("$total $effect")
}
