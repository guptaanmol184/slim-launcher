package com.sduduzog.slimlauncher.ui

import android.content.res.Resources
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.sduduzog.slimlauncher.R
import com.sduduzog.slimlauncher.navigation.NavigationDispatcher
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity2 : AppCompatActivity() {

    @Inject
    lateinit var navigationDispatcher: NavigationDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity2)

        navigationDispatcher.navigationCommands.startListening {
            it.invoke(Navigation.findNavController(this, R.id.nav_graph2))
        }
    }

    override fun getTheme(): Resources.Theme {
        val theme = super.getTheme()
        theme.applyStyle(resolveTheme(), true)
        return theme
    }

    companion object {
        fun resolveTheme(): Int {
            return R.style.AppTheme2
        }
    }
}