package bj33191

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val budget = br.readLine().toInt()
    val watermelon = br.readLine().toInt()
    val pomegranates = br.readLine().toInt()
    val nuts = br.readLine().toInt()
    println(
        if (budget >= watermelon) {
            "Watermelon"
        } else if (budget >= pomegranates) {
            "Pomegranates"
        } else if (budget >= nuts) {
            "Nuts"
        } else {
            "Nothing"
        }
    )
}
