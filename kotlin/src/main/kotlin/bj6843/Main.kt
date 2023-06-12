package bj6843

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val a = br.readLine().replace(" ", "")
    val b = br.readLine().replace(" ", "")
    val aCount = IntArray(26)
    val bCount = IntArray(26)
    for (i in a.indices) {
        aCount[a[i] - 'A']++
    }
    for (i in b.indices) {
        bCount[b[i] - 'A']++
    }
    var isAnagram = true
    for (i in 0 until 26) {
        if (aCount[i] != bCount[i]) {
            isAnagram = false
            break
        }
    }
    println(
        if (isAnagram) {
            "Is an anagram."
        } else {
            "Is not an anagram."
        }
    )
}
