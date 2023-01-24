package ru.sotnikov.selecter

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import ru.sotnikov.selecter.ui.SelecterViewModel

val selecterModule = module {
    viewModel { SelecterViewModel(get()) }
}
