package com.smartsoft.bj.core


enum class BjAction {
    Deal, Hit, Stay
}

typealias BjDispatch = (action: BjAction) -> Unit

enum class Page {
    Home, GameText, GameGraphic
}

typealias Nav = (page: Page) -> Unit