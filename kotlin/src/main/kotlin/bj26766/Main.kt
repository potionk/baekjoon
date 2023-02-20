package bj26766

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val heart = " @@@   @@@ \n" +
            "@   @ @   @\n" +
            "@    @    @\n" +
            "@         @\n" +
            " @       @ \n" +
            "  @     @  \n" +
            "   @   @   \n" +
            "    @ @    \n" +
            "     @     \n"
    print(heart.repeat(br.readLine().toInt()))
    br.close()
}
