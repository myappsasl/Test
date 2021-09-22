package prueba.tecnica.openbank.presentation.characterDetail.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import prueba.tecnica.openbank.R
import prueba.tecnica.openbank.databinding.CharactersDetailFragmentBinding
import prueba.tecnica.openbank.domain.Character
import prueba.tecnica.openbank.presentation.common.fragment.BaseFragment
import prueba.tecnica.openbank.presentation.common.utils.getParamByClass
import prueba.tecnica.openbank.presentation.common.utils.setParamByClass

class CharacterDetailFragment: BaseFragment() {

    private lateinit var binding :  CharactersDetailFragmentBinding

    companion object {

        @JvmStatic
        fun getInstance(character: Character?) = CharacterDetailFragment().apply {
            setParamByClass(character)
        }
    }

    override fun initializeView() {
        //Empty block
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = CharactersDetailFragmentBinding.inflate(inflater, container, false)
        val character: Character? = getParamByClass()

        character?.let {
            with(binding){
                setImage(image, it.uri)
                name.text = it.name
                description.text = it.description
            }
        }
        return binding.root
    }

    private fun setImage(imageView: ImageView, path: String) =
        context?.let {
            Glide.with(it)
                .load(path)
                .error(R.drawable.character_empty)
                .into(imageView)
        }
}