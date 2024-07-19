package bj9783

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val str = br.readLine()
    str.forEach { c ->
        print(
            if (c.isLetter()) {
                if (c in 'a'..'z') {
                    fillZero(c - 'a' + 1)
                } else {
                    fillZero(c - 'A' + 27)
                }
            } else if (c.isDigit()) {
                "#$c"
            } else {
                c
            }
        )
    }
}

fun fillZero(num: Int): String {
    return if (num < 10) {
        "0$num"
    } else {
        num.toString()
    }
}
