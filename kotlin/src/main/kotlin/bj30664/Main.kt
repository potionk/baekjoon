package bj30664

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var n = br.readLine().toBigInteger()
    while(n != 0.toBigInteger()) {
        if(n % 42.toBigInteger() == 0.toBigInteger()) {
            println("PREMIADO")
        } else {
            println("TENTE NOVAMENTE")
        }
        n = br.readLine().toBigInteger()
    }
}
