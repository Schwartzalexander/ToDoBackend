package de.springbootarchetype.domain.results

import de.springbootarchetype.enums.Outcome


open class Result(open var outcome: Outcome) {

    open fun isOk() = outcome === Outcome.OK

    companion object {
        /**
         * Creates a new Result with the Outcome OK.
         * @return a new Result with the Outcome OK
         */
        fun getInstanceOk(): Result = Result(Outcome.OK)

        /**
         * Creates a new Result with the Outcome FAIL.
         * @return a new Result with the Outcome FAIL
         */
        fun getInstanceFail(): Result = Result(Outcome.FAIL)
    }
}