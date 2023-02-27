package bj2942

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val rg = br.readLine().split(" ").map { it.toInt() }
    val r = rg[0]
    val g = rg[1]

    val gcd = gcd(r, g)

    for (k in gcd downTo 1) {
        if (r % k == 0 && g % k == 0) {
            val x = r / k
            val y = g / k
            bw.write("$k $x $y\n")
        }
    }
    br.close()
    bw.close()
}

fun gcd(a: Int, b: Int): Int {
    return if (b == 0) a else gcd(b, a % b)
}
