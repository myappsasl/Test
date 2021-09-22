package prueba.tecnica.openbank.presentation.common.presenter

import prueba.tecnica.openbank.presentation.common.view.BaseView

interface Presenter<T : BaseView> {
    fun initialize(view: T)
    fun dispose()
}