package bj15720

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val bcd = br.readLine().split(" ").map { it.toInt() }
    val min = bcd.min()
    val max = bcd.max()
    val burgers = br.readLine().split(" ").map { it.toInt() }.sorted().reversed()
    val sides = br.readLine().split(" ").map { it.toInt() }.sorted().reversed()
    val drinks = br.readLine().split(" ").map { it.toInt() }.sorted().reversed()
    var noSaleTotal = 0
    var total = 0
    for (i in 0 until min) {
        val sum = burgers[i] + sides[i] + drinks[i]
        total += (sum * 0.9).toInt()
        noSaleTotal += sum
    }
    for (i in min until max) {
        if (i < burgers.size) {
            total += burgers[i]
            noSaleTotal += burgers[i]
        }
        if (i < drinks.size) {
            total += drinks[i]
            noSaleTotal += drinks[i]
        }
        if (i < sides.size) {
            total += sides[i]
            noSaleTotal += sides[i]
        }
    }
    bw.write("$noSaleTotal\n${total}")
    br.close()
    bw.close()
}
