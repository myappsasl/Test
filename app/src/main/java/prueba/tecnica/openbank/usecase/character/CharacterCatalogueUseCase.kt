package prueba.tecnica.openbank.usecase.character

import prueba.tecnica.openbank.domain.repository.CharacterCatalogueRepository

class CharacterCatalogueUseCase (private val repository: CharacterCatalogueRepository){
    suspend fun invoke() = repository.getCatalogue()
}