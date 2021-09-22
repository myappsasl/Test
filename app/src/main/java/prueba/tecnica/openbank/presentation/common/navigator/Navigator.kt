package prueba.tecnica.openbank.presentation.common.navigator

import android.content.Context
import prueba.tecnica.openbank.domain.Character

interface Navigator {
    fun goToCharacterDetail(context: Context, character: Character)
}