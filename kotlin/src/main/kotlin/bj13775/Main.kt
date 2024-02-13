package bj13775

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var shift = br.readLine().toInt()
    val input = br.readLine()
    for (c in input) {
        if (c == ' ') {
            bw.write(" ")
            continue
        }
        bw.write("${decrypt(c, (shift))}")
        shift++
        shift %= 26
        if (shift == 0) shift++
    }
    bw.close()
}

fun decrypt(c: Char, shift: Int): Char {
    if (c in 'a'..'z') {
        var result = c - shift
        if (result < 'a') {
            result += 26
        }
        return result
    }
    return c
}
