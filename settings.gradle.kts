pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        maven { url= uri("https://jitpack.io") }
      //  maven { url= uri("https://maven.aliyun.com/repository/jcenter") }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url= uri("https://jitpack.io") }
        maven { url= uri("https://maven.aliyun.com/repository/jcenter") }
    }
}

rootProject.name = "Training"
include(":app")
 