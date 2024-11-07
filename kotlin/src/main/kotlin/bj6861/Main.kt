package bj6861

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val normalArray = br.readLine().toCharArray()
    val encryptedArray = br.readLine().toCharArray()
    val reverseMappingTable = mutableMapOf<Char, Char>()
    for (i in normalArray.indices) {
        reverseMappingTable[encryptedArray[i]] = normalArray[i]
    }
    for (i in encryptedArray.indices) {
        reverseMappingTable[encryptedArray[i]] = normalArray[i]
    }
    if (reverseMappingTable.size == 26) {
        if (reverseMappingTable[' '] == null) {
            reverseMappingTable[' '] = ' '
        } else {
            for (i in 'A'..'Z') {
                if (reverseMappingTable[i] == null) {
                    for (j in 'A'..'Z') {
                        if (!reverseMappingTable.containsValue(j)) {
                            reverseMappingTable[i] = j
                            break
                        }
                    }
                }
            }
        }
    }

    val decryptedTarget = br.readLine().toCharArray()
    println(decryptedTarget.joinToString("") { reverseMappingTable.getOrDefault(it, '.').toString() })
}
