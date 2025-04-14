package bj33779

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val charArray = br.readLine().toCharArray()
    fun isPalindrome(charArray: CharArray): Boolean {
        var left = 0
        var right = charArray.size - 1
        while (left < right) {
            if (charArray[left] != charArray[right]) {
                return false
            }
            left++
            right--
        }
        return true
    }
    if (isPalindrome(charArray)) {
        println("beep")
    } else {
        println("boop")
    }
}
