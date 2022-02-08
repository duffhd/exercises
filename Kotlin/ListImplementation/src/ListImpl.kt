const val DEFAULT_LIST_INIT_SIZE = 5

interface ListImpl<T : Any> {
    fun add(item: T)
    fun contains(item: T): Boolean
    operator fun get(position: Int): T
    fun remove(position: Int): Boolean
    fun size(): Int
    fun realSize(): Int
}