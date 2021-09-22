package prueba.tecnica.openbank.presentation.common.navigator

import android.content.Context
import prueba.tecnica.openbank.domain.Character
import prueba.tecnica.openbank.presentation.characterDetail.CharacterDetailActivity

class NavigatorImpl: Navigator {

    override fun goToCharacterDetail(context: Context, character: Character) {
        context.startActivity(CharacterDetailActivity.getInstance(context, character))
    }
}