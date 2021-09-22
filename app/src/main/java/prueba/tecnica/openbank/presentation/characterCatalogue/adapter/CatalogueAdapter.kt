package prueba.tecnica.openbank.presentation.characterCatalogue.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import prueba.tecnica.openbank.R
import prueba.tecnica.openbank.databinding.CharacterItemBinding
import prueba.tecnica.openbank.domain.Character
import prueba.tecnica.openbank.presentation.common.utils.inflate

class CatalogueAdapter(private val context: Context, private val onClick: (character: Character) -> Unit) :
    RecyclerView.Adapter<CatalogueAdapter.ViewHolder>() {

    var data = emptyList<Character>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.character_item))

    override fun onBindViewHolder(holder: CatalogueAdapter.ViewHolder, position: Int) =
        holder.bind(data[position])

    override fun getItemCount() = data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = CharacterItemBinding.bind(itemView)

        fun bind(character: Character) {
            with(binding) {
                setImage(image, character.uri)
                name.text = character.name
            }
            itemView.setOnClickListener { onClick(character) }
        }
    }

    private fun setImage(imageView: ImageView, path: String) =
        Glide.with(context)
            .load(path)
            .error(R.drawable.character_empty)
            .into(imageView)

    fun updateItems(list: List<Character>){
        (data + list).also { data = it }
        notifyDataSetChanged()
    }
}