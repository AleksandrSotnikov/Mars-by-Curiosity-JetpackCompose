package ru.sotnikov.settings

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.sotnikov.settings.ui.SettingViewModel

val settingModule = module {
    viewModel { SettingViewModel(get()) }
}
