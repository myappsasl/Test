package prueba.tecnica.openbank.presentation.common.utils

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import prueba.tecnica.openbank.presentation.common.fragment.BaseFragment
import java.io.Serializable

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
    LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

inline fun <reified T : Serializable> Intent.setParamByClass(obj: T?, tag: String = "") {
    putExtra(T::class.java.name + tag, obj)
}

inline fun <reified T : Serializable> AppCompatActivity.getParamByClass(data: Intent? = intent, tag: String = ""): T? =
    data?.extras?.get(T::class.java.name + tag) as T?

inline fun <reified T : Serializable> BaseFragment.setParamByClass(obj: T?, tag: String = "") {
    if (arguments == null) {
        arguments = android.os.Bundle()
    }
    arguments?.putSerializable(T::class.java.name + tag, obj)
}

inline fun <reified T : Serializable> BaseFragment.getParamByClass(tag: String = ""): T? =
    arguments?.getSerializable(T::class.java.name + tag) as T?