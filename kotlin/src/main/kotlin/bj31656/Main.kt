package bj31656

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine().toCharArray()
    var before = str[0]
    print(before)
    str.forEach { c ->
        if (before != c) {
            print(c)
            before = c
        }
    }
}
