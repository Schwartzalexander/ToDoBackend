package de.springbootarchetype.domain.results

import de.springbootarchetype.enums.Outcome


open class MessageResult(override var outcome: Outcome, var message: String) : Result(outcome) {
 
    companion object {
        /**
         * Creates a new Result with the Outcome OK.
         * @return
         */
        fun getInstanceOk(): MessageResult = MessageResult(Outcome.OK, "")

        /**
         * Creates a new Result with the Outcome FAIL.
         * @return
         */
        fun getInstanceFail(): MessageResult = MessageResult(Outcome.FAIL, "")
    }

}