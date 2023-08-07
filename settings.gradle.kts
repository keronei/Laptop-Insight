dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Laptop Insight"
include(":app")
include(":domain")
include(":content:local")
include(":content:remote")
include(":content:repository")
