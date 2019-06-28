package board

fun createSquareBoard(width: Int): SquareBoard {
    val sq = SquareBoardImpl(width)

    sq.cells = createBoard(width)

    return sq
}

fun <T> createGameBoard(width: Int): GameBoard<T> {
    val gb = GameBoardImpl<T>(width)

    gb.cells = createBoard(width)
    gb.cells.forEach { it.forEach { cell: Cell -> gb.cellValues += cell to null } }

    return gb
}


private fun createBoard(width: Int): Array<Array<Cell>> {
    var board = arrayOf<Array<Cell>>()

    for (i in 1..width) {
        var array = arrayOf<Cell>()
        for (j in 1..width) {
            array += Cell(i, j)
        }
        board += array
    }
    return board
}
