package bj4659

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    while (true) {
        val password = br.readLine()
        if (password == "end") {
            break
        }
        println(
            "<$password> is ${if (validatePassword(password)) "acceptable." else "not acceptable."}"
        )
    }
}

fun validatePassword(password: String): Boolean {
    var hasVowel = false
    var prevChar = ' '
    var vowelCount = 0
    var consonantCount = 0
    for (c in password) {
        if (c in "aeiou") {
            hasVowel = true
            vowelCount++
            consonantCount = 0
        } else {
            consonantCount++
            vowelCount = 0
        }
        if (c == prevChar) {
            if (prevChar == 'e' || prevChar == 'o') {
                continue
            }
            return false
        }
        if (vowelCount == 3 || consonantCount == 3) {
            return false
        }
        prevChar = c
    }
    return hasVowel
}
