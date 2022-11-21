package bridge.view

import bridge.constants.Message
import bridge.data.GameHistory
import bridge.data.GameResult
import bridge.common.println
import bridge.constants.ErrorMessage

object OutputView {

    fun printStartGame() {
        println(Message.StartGame)
    }

    fun printInputBridgeSize() {
        println("\n${Message.InputBridgeSize}")
    }

    fun printSelectNextFloor() {
        println("\n${Message.SelectNextFloor}")
    }

    fun printSelectRetryOrFinishGame() {
        println("\n${Message.SelectRetryOrFinishGame}")
    }

    fun printMap(history: GameHistory) {
        println(buildHistoryOf(history.upstairs))
        println(buildHistoryOf(history.downstairs))
    }

    fun printResult(result: GameResult) {
        val messages = Message.FinishGame

        println("\n${messages[0]}")
        printMap(result.lastHistory)
        println("\n${messages[1]}", if (result.isSuccess) Message.Success else Message.Failure)
        println(messages[2], result.tryCount)
    }

    fun printError(t: Throwable) {
        println("${ErrorMessage.PREFIX} ${t.message}")
    }

    private fun buildHistoryOf(data: List<Char>): String {
        return data.joinToString(prefix = "[", postfix = "]", separator = "|") { " $it " }
    }
}
