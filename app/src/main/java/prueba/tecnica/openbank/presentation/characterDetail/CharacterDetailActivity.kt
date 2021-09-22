package prueba.tecnica.openbank.presentation.characterDetail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import prueba.tecnica.openbank.R
import prueba.tecnica.openbank.databinding.CharactersDetailActivityBinding
import prueba.tecnica.openbank.domain.Character
import prueba.tecnica.openbank.presentation.characterDetail.fragment.CharacterDetailFragment
import prueba.tecnica.openbank.presentation.common.BaseActivity
import prueba.tecnica.openbank.presentation.common.utils.getParamByClass
import prueba.tecnica.openbank.presentation.common.utils.setParamByClass

class CharacterDetailActivity: BaseActivity() {

    private lateinit var binding: CharactersDetailActivityBinding

    companion object{

        @JvmStatic
        fun getInstance(context: Context, character: Character) =
            Intent(context, CharacterDetailActivity::class.java).apply {
                setParamByClass(character)
            }
    }

    override fun initializeView() {
        supportActionBar?.title = getString(R.string.character_detail_title)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = CharactersDetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initFragment(binding.fragmentContainer.id, CharacterDetailFragment.getInstance(getParamByClass()))
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            android.R.id.home -> {
                close()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}