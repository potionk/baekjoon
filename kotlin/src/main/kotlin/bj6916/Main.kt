package bj6916

import java.io.*

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    println(showNumber(br.readLine().toInt()))
}

fun showNumber(num: Int): String {
    val number = arrayOf(
        """ * * *
*     *
*     *
*     *

*     *
*     *
*     *
 * * *""",
        """
      *
      *
      *

      *
      *
      *
""",
        """ * * *
      *
      *
      *
 * * *
*
*
*
 * * * """,
        """ * * *
      *
      *
      *
 * * *
      *
      *
      *
 * * *""",
        """
*     *
*     *
*     *
 * * *
      *
      *
      *
""",
        """ * * *
*
*
*
 * * *
      *
      *
      *
 * * *""",
        """ * * *
*
*
*
 * * *
*     *
*     *
*     *
 * * *""",
        """ * * *
      *
      *
      *

      *
      *
      *
""",
        """ * * *
*     *
*     *
*     *
 * * *
*     *
*     *
*     *
 * * *""",
        """ * * *
*     *
*     *
*     *
 * * *
      *
      *
      *
 * * *"""
    )
    return number[num]
}
