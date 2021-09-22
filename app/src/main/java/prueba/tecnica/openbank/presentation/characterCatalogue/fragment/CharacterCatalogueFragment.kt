package prueba.tecnica.openbank.presentation.characterCatalogue.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import prueba.tecnica.openbank.R
import prueba.tecnica.openbank.databinding.CharactersCatalogueFragmentBinding
import prueba.tecnica.openbank.domain.Character
import prueba.tecnica.openbank.presentation.characterCatalogue.CharacterCatalogueView
import prueba.tecnica.openbank.presentation.characterCatalogue.adapter.CatalogueAdapter
import prueba.tecnica.openbank.presentation.characterCatalogue.presenter.CharacterCataloguePresenter
import prueba.tecnica.openbank.presentation.common.fragment.BaseFragment
import prueba.tecnica.openbank.presentation.common.navigator.NavigatorImpl

class CharacterCatalogueFragment : BaseFragment(), CharacterCatalogueView {

    private lateinit var binding: CharactersCatalogueFragmentBinding
    private val presenter = CharacterCataloguePresenter(::loadCharacters, ::onFailure)
    private lateinit var adapter : CatalogueAdapter
    private val navigator = NavigatorImpl()

    companion object {
        fun getInstance() = CharacterCatalogueFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharactersCatalogueFragmentBinding.inflate(inflater, container, false)

        adapter = CatalogueAdapter(getBaseActivity(), ::onClickCharacter)

        binding.apply {
            charactersList.adapter = this@CharacterCatalogueFragment.adapter
        }
        return binding.root
    }

    override fun initializeView() {
        presenter.initialize(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dispose()
    }

    override fun showLoading() {
        binding.progress.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        binding.progress.visibility = View.GONE
    }

    private fun loadCharacters(data: List<Character>){
        adapter.updateItems(data)
    }

    private fun onFailure(){
        showMessage(getString(R.string.something_wrong))
    }

    private fun onClickCharacter(character: Character) {
        navigator.goToCharacterDetail(getBaseActivity(), character)
    }
}