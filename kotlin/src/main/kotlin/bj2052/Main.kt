package bj2052

import java.io.*
import java.math.BigDecimal

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toBigDecimal()
    var divided = BigDecimal.ONE
    repeat(n.toInt()) {
        divided *= BigDecimal.valueOf(2L)
    }
    println(BigDecimal.ONE.divide(divided).toPlainString())
}
