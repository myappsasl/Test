package prueba.tecnica.openbank.presentation.common

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import prueba.tecnica.openbank.presentation.common.view.BaseView

abstract class BaseActivity : AppCompatActivity(), BaseView {

    protected fun initFragment(containerId: Int, fragment: Fragment) {
        try {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(containerId, fragment)
            transaction.commit()
        } catch (e: Exception) {
            Log.e("ERROR", "Error in initFragmentContainer: ${e.localizedMessage}")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
    }

    abstract fun initializeView()

    override fun close() {
        finish()
    }

    override fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}