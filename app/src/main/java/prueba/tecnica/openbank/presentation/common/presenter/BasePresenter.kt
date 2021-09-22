package prueba.tecnica.openbank.presentation.common.presenter

import prueba.tecnica.openbank.presentation.common.view.BaseView

abstract class BasePresenter<T: BaseView>: Presenter<T> {

    var view: T? = null

    override fun initialize(view: T) {
        this.view = view
    }

    override fun dispose() {
        this.view = null
    }
}