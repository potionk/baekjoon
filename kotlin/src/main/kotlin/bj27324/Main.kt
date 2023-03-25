package bj27324

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val s = br.readLine().toCharArray()
    println(
        if (s[0] == s[1]) {
            "1"
        } else {
            "0"
        }
    )
    br.close()
}
