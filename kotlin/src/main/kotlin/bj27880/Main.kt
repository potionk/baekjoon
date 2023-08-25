package bj27880

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var result = 0
    for(i in 0 until 4){
        val (path, height) = br.readLine().split(" ")
        result += height.toInt() * if(path == "Stair") 17 else 21
    }
    println(result)
}
