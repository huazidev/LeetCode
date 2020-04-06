/**
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 *
 * @author hua on 2020/01/03.
 */
class TwoSum {
    // solution one
    fun twoSum1(nums: IntArray, target: Int): IntArray {
        nums.forEachIndexed { index, _ ->
            for (i in (index + 1)..nums.size) {
                if (nums[index] + nums[i] == target) {
                    return intArrayOf(index, i)
                }
            }
        }
        return IntArray(2)
    }

    // solution two
    fun twoSum(nums: IntArray, target: Int): IntArray {
        // key is target minus value of nums, value is indices of nums
        val resultMap = mutableMapOf<Int, Int>()
        nums.forEachIndexed { index, value ->
            if (resultMap.containsKey(value)) {
                val anotherIndex: Int = resultMap[value]!!
                return intArrayOf(anotherIndex, index)
            } else {
                resultMap[target - value] = index
            }
        }
        // no result, return empty array
        return IntArray(2)
    }
}

fun main() {
    val nums = intArrayOf(2, 7, 11, 15)
    val result1 = TwoSum().twoSum1(nums, 9)
    println("result1: ${result1.joinToString()}")

    val result = TwoSum().twoSum(nums, 9)
    println("result: ${result.joinToString()}")
}
