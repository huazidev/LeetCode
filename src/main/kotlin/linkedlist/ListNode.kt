package linkedlist

class ListNode(var value: Int = -1, var next: ListNode? = null) {
    override fun toString(): String {
        return "$value -> ${next?.toString()}"
    }

    companion object {
        fun quickListNode(intArray: List<Int>): ListNode {
            val listNode = ListNode()
            intArray.reversed().forEach {
                val tempNode = ListNode(it)
                tempNode.next = listNode.next
                listNode.next = tempNode
            }
            return listNode.next!!
        }
    }
}