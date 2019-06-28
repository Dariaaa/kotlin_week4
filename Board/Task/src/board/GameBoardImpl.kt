package board


class GameBoardImpl<T>(override val width: Int) : SquareBoardImpl(width), GameBoard<T> {

    val cellValues = mutableMapOf<Cell, T?>()


    override fun get(cell: Cell): T? = cellValues.get(cell)

    override fun set(cell: Cell, value: T?) {
        cellValues += cell to value
    }

    override fun any(predicate: (T?) -> Boolean): Boolean = cellValues.values.any(predicate)

    override fun all(predicate: (T?) -> Boolean): Boolean = cellValues.values.all(predicate)

    override fun filter(predicate: (T?) -> Boolean): Collection<Cell> = cellValues.filterValues { predicate.invoke(it) }.keys

    override fun find(predicate: (T?) -> Boolean): Cell? = cellValues.filter{ predicate.invoke(it.value) }.keys.first()


}