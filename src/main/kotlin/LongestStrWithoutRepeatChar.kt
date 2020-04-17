import kotlin.math.max

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * @author hua on 2020/04/06.
 */
class LongestStrWithoutRepeatChar {

    fun lengthOfLongestSubstring(s: String): Int {
        val length = s.length
        var max = 0
        for (i in 0 until length) {
            for (j in i + 1 until length) {
                if (isAllUnique(s, i, j)) {
                    max = max(max, j - i)
                }
            }
        }
        return max
    }

    private fun isAllUnique(s: String, start: Int, end: Int): Boolean {
        val set = hashSetOf<Char>()
        for (i in start until end) {
            val char = s[i]
            if (set.contains(char)) return false
            set.add(char)
        }
        return true
    }

    fun lengthOfLongestSubStr(s: String): Int {
        if (s.isEmpty()) return 0

        val map = hashMapOf<Char, Int>()
        var max = 0
        var left = 0

        for (i in s.indices) {
            if (map.containsKey(s[i])) {
                left = max(left, (map[s[i]] ?: 0) + 1)
            }
            map[s[i]] = i
            max = max(max, i - left + 1)
        }

        return max
    }

}

fun main() {
    println(LongestStrWithoutRepeatChar().lengthOfLongestSubstring("abcabcbb") == 3)
    println(LongestStrWithoutRepeatChar().lengthOfLongestSubstring("bbbbb") == 1)
    println(LongestStrWithoutRepeatChar().lengthOfLongestSubstring("pwwkew") == 3)

    println(LongestStrWithoutRepeatChar().lengthOfLongestSubStr("abcabcbb") == 3)
    println(LongestStrWithoutRepeatChar().lengthOfLongestSubStr("bbbbb") == 1)
    println(LongestStrWithoutRepeatChar().lengthOfLongestSubStr("pwwkew") == 3)
}