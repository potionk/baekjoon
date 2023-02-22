package bj13235

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine().toCharArray()
    var isPalindrome = true
    for (i in 0 until str.size / 2) {
        if (str[i] != str[str.size - i - 1]) {
            isPalindrome = false
            break
        }
    }
    println(isPalindrome)
    br.close()
}
