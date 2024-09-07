package bj25497

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val str = br.readLine().toCharArray()
    val linkedSkill = mutableListOf<Char>()
    var count = 0
    for (i in 0 until n) {
        if (str[i].isLetter()) {
            if (str[i] == 'L' || str[i] == 'S') {
                linkedSkill.add(str[i])
            } else {
                if(linkedSkill.isEmpty()) {
                    println(count)
                    return
                }
                if (str[i] == 'R') {
                    if (linkedSkill.contains('L')) {
                        linkedSkill.remove('L')
                        count++
                    } else {
                        println(count)
                        return
                    }
                } else if (str[i] == 'K') {
                    if (linkedSkill.contains('S')) {
                        linkedSkill.remove('S')
                        count++
                    } else {
                        println(count)
                        return
                    }
                }
            }
        } else {
            count++
        }
    }
    println(count)
}
