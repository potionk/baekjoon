package bj28637

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    repeat(n) {
        val charArray = br.readLine().toCharArray()
        print(charArray[0].toLowerCase())
        for (i in 1 until charArray.size) {
            // charArray[i] 가 대문자면
            if (charArray[i].isUpperCase()) {
                print("_")
                print(charArray[i].toLowerCase())
            } else {
                print(charArray[i])
            }
        }
        println()
    }
}
