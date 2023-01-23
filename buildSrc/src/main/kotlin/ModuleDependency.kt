object ModuleDependency {

    const val app = ":app"
    const val navigation = ":navigation"

    object UI {
        private const val directory = ":ui"

        const val home = "$directory:home"
        const val settings = "$directory:settings"
    }

    object Feature {
        private const val directory = ":feature"


        const val marsByCuriosity_api = "$directory:marsbycuriosity_api"
        const val marsByCuriosity_impl = "$directory:marsbycuriosity_impl"
    }

    object Core {
        private const val directory = ":core"

        const val ui = "$directory:ui"
    }
}
