package prueba.tecnica.openbank.presentation.characterCatalogue.presenter

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import prueba.tecnica.openbank.domain.Character
import prueba.tecnica.openbank.domain.repository.CharacterCatalogueRepository
import prueba.tecnica.openbank.presentation.characterCatalogue.CharacterCatalogueView
import prueba.tecnica.openbank.presentation.common.presenter.BasePresenter
import prueba.tecnica.openbank.usecase.character.CharacterCatalogueUseCase

class CharacterCataloguePresenter(
    var onSuccess: (List<Character>) -> Unit,
    var onFailure: () -> Unit
) :
    BasePresenter<CharacterCatalogueView>() {

    private var useCase = CharacterCatalogueUseCase(CharacterCatalogueRepository())

    override fun initialize(view: CharacterCatalogueView) {
        super.initialize(view)
        getCharacters()
    }

    private fun getCharacters() {
        view?.showLoading()
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val resp = withContext(Dispatchers.IO) {
                    useCase.invoke()
                }
                onSuccess(resp)
                view?.hideLoading()
            } catch (e: Exception) {
                onFailure
            }
        }
    }
}