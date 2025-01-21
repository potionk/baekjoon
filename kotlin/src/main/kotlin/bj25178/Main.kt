package bj25178

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val a = br.readLine()
    val b = br.readLine()
    println(if (isDuramuri(a, b)) "YES" else "NO")
}

fun isDuramuri(a: String, b: String): Boolean {
    val aCharArray = a.toCharArray()
    val bCharArray = b.toCharArray()
    if (!isAnagram(aCharArray, bCharArray)) {
        return false
    }
    if (!(aCharArray.first() == bCharArray.first() && aCharArray.last() == bCharArray.last())) {
        return false
    }
    if (removeVowel(a) != removeVowel(b)) {
        return false
    }
    return true
}

fun isAnagram(a: CharArray, b: CharArray): Boolean {
    val aAlphaBetCount = IntArray(26)
    val bAlphaBetCount = IntArray(26)
    for (i in a.indices) {
        aAlphaBetCount[a[i] - 'a']++
        bAlphaBetCount[b[i] - 'a']++
    }
    return aAlphaBetCount.contentEquals(bAlphaBetCount)
}

fun removeVowel(s: String): String {
    return s.filter { it !in "aeiou" }
}
