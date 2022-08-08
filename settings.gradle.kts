pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "compose-theme"
include(
    ":nested_themes:sample",
    ":nested_themes:themes:common",
    ":nested_themes:themes:redesign"
)
