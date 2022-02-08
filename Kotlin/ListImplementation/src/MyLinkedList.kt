class Node<T : Any>(
    var data: T,
    var nextNode: Node<T>?
)

class MyLinkedList<T : Any> : ListImpl<T> {

    private var nodeArray: Node<T>? = null
    private var count = 0

    override fun add(item: T) {
        count++
        if (nodeArray == null) {
            nodeArray = Node(item, null)
            return
        }

        var currentNode = nodeArray
        while (currentNode?.nextNode != null) {
            currentNode = currentNode.nextNode
        }

        currentNode?.nextNode = Node(item, null)
    }

    override fun contains(item: T): Boolean {
        nodeArray?.let {
            if (item == it.data) {
                return true
            }
        } ?: return false

        var currentNode = nodeArray
        while (currentNode?.nextNode != null) {
            if (currentNode.data == item) {
                return true
            }
            currentNode = currentNode.nextNode
        }

        return currentNode?.data == item
    }

    override operator fun get(position: Int): T {
        if (position < 0 || position > count - 1) {
            throw IndexOutOfBoundsException("You tried to access index $position but the array size is: $count")
        }

        return if (position == 0) {
            nodeArray?.data as T
        } else {
            var counter = 0
            var currentNode = nodeArray

            while (counter < position) {
                counter++
                currentNode = currentNode?.nextNode
            }
            currentNode?.data as T
        }
    }

    override fun remove(position: Int): Boolean {
        if (position < 0 || position > count - 1) {
            throw IndexOutOfBoundsException("You tried to access index $position but the array size is: $count")
        }

        count--
        return when (position) {
            0 -> {
                nodeArray = nodeArray?.nextNode
                true
            }
            count -> {
                var counter = 0
                var currentNode = nodeArray

                while (counter < position - 1) {
                    counter++
                    currentNode = currentNode?.nextNode
                }
                currentNode?.nextNode = null
                true
            }
            else -> {
                var counter = 0
                var currentNode = nodeArray

                while (counter < position - 1) {
                    counter++
                    currentNode = currentNode?.nextNode
                }
                currentNode?.nextNode = currentNode?.nextNode?.nextNode

                while (currentNode?.nextNode != null ) {
                    currentNode = currentNode.nextNode
                }

                true
            }
        }
    }

    override fun size(): Int = count

    override fun realSize(): Int = count
}