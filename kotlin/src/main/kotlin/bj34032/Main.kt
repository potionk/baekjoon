package bj34032

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    if(br.readLine().count { it == 'O' } * 2 >= n) {
        println("Yes")
    } else {
        println("No")
    }
}
