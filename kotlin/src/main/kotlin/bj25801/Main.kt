package bj25801

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    val charCountArray = IntArray(26)
    for (i in str.indices) {
        charCountArray[str[i] - 'a']++
    }
    var oddCount = 0
    var evenCount = 0
    for (i in charCountArray.indices) {
        if (charCountArray[i] == 0) {
            continue
        }
        if (charCountArray[i] % 2 == 0) {
            evenCount++
        } else {
            oddCount++
        }
    }
    println(if (evenCount > 0 && oddCount == 0) "0" else if (oddCount > 0 && evenCount == 0) "1" else "0/1")
}
