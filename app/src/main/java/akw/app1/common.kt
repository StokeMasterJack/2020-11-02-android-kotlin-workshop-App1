package akw.app1

/*
Action: state-changing blackjack event
 */

enum class BlackjackAction {
    Deal, Hit, Stay
}

typealias BlackjackDispatch = (BlackjackAction) -> Unit