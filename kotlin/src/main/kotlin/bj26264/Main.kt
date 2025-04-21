package bj26264

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val charArray = br.readLine().toCharArray()
    var idx = 0
    var securityCount = 0
    var bigdataCount = 0
    while(idx < charArray.size) {
        if(charArray[idx] == 's') {
            securityCount++
            idx += 8
        } else {
            bigdataCount++
            idx += 7
        }
    }
    if(securityCount > bigdataCount) {
        println("security!")
    } else if(securityCount < bigdataCount) {
        println("bigdata?")
    } else {
        println("bigdata? security!")
    }
}