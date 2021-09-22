package prueba.tecnica.openbank.presentation.characterCatalogue

import android.os.Bundle
import prueba.tecnica.openbank.R
import prueba.tecnica.openbank.databinding.CharactersCatalogueActivityBinding
import prueba.tecnica.openbank.databinding.CharactersCatalogueActivityBinding.inflate
import prueba.tecnica.openbank.domain.repository.CharacterCatalogueRepository
import prueba.tecnica.openbank.presentation.characterCatalogue.fragment.CharacterCatalogueFragment
import prueba.tecnica.openbank.presentation.common.BaseActivity

class CharacterCatalogueActivity : BaseActivity() {

    private lateinit var binding: CharactersCatalogueActivityBinding

    lateinit var repo: CharacterCatalogueRepository

    override fun initializeView() {
        supportActionBar?.title = getString(R.string.characters_title)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = inflate(layoutInflater)
        setContentView(binding.root)
        initFragment(binding.fragmentContainer.id, CharacterCatalogueFragment.getInstance())
    }
}