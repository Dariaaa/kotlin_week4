package board

open class SquareBoardImpl(override val width: Int) : SquareBoard {

    var cells = arrayOf(arrayOf<Cell>())


    override fun getCellOrNull(i: Int, j: Int): Cell? =
            when {
                i > width || j > width || i == 0 || j == 0 -> null
                else -> getCell(i, j)
            }


    override fun getCell(i: Int, j: Int): Cell = cells[i - 1][j - 1]


    override fun getAllCells(): Collection<Cell> =
            IntRange(1, width).flatMap { i: Int ->
                IntRange(1, width)
                        .map { j: Int -> getCell(i, j) }
            }
                    .toList()


    override fun getRow(i: Int, jRange: IntProgression): List<Cell> =
            when {
                jRange.last > width -> IntRange(jRange.first, width).map { j: Int -> getCell(i, j) }.toList()
                else -> jRange.map { j: Int -> getCell(i, j) }.toList()
            }


    override fun getColumn(iRange: IntProgression, j: Int): List<Cell> =
            when {
                iRange.last > width -> IntRange(iRange.first, width).map { i: Int -> getCell(i, j) }.toList()
                else -> iRange.map { i: Int -> getCell(i, j) }.toList()
            }

    override fun Cell.getNeighbour(direction: Direction): Cell? =
            when (direction) {
                Direction.LEFT -> getCellOrNull(i, j - 1)
                Direction.RIGHT -> getCellOrNull(i, j + 1)
                Direction.UP -> getCellOrNull(i - 1, j)
                Direction.DOWN -> getCellOrNull(i + 1, j)
            }


}
