package bj16189

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val n = str.length
    if (isPalindrome(str)) {
        println("YES")
    } else {
        println("NO")
    }
}

fun isPalindrome(str: String): Boolean {
    val n = str.length
    for (i in 0 until n / 2) {
        if (str[i] != str[n - i - 1]) {
            return false
        }
    }
    return true
}
