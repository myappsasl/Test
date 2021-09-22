package prueba.tecnica.openbank.presentation.common.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import prueba.tecnica.openbank.presentation.common.BaseActivity
import prueba.tecnica.openbank.presentation.common.view.BaseView

abstract class BaseFragment : Fragment(), BaseView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
    }

    abstract fun initializeView()

    override fun close() {
        activity?.supportFragmentManager?.popBackStackImmediate()
    }

    override fun showMessage(message: String) {
        getBaseActivity().showMessage(message)
    }

    fun getBaseActivity(): BaseActivity {
        return activity as BaseActivity
    }
}