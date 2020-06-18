package linkedlist

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 * Example:

 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author hua on 2020/04/06.
 */
class AddTwoNumbers {

    // Time Complexity: O(max(m,n)), Space complexity: O(max(m,n))
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1

        var temp1 = l1
        var temp2 = l2
        val resultListNode = ListNode()
        var currentNode = resultListNode

        var carrier = 0

        while (temp1 != null || temp2 != null) {
            val x = temp1?.value ?: 0
            val y = temp2?.value ?: 0
            val sum = x + y + carrier
            carrier = sum / 10

            currentNode.next = ListNode(sum % 10)
            currentNode.next?.let {
                currentNode = it
            }

            temp1 = temp1?.next
            temp2 = temp2?.next
        }

        if (carrier > 0) {
            currentNode.next = ListNode(carrier)
        }
        return resultListNode.next
    }

}

fun main() {
    val l1 = ListNode.quickListNode(intArrayOf(2, 4, 3).toMutableList())
    val l2 = ListNode.quickListNode(intArrayOf(5, 6, 4).toMutableList())

    val addTwoNumbers = AddTwoNumbers().addTwoNumbers(l1, l2)
    println(addTwoNumbers.toString())
}