buildscript {
    repositories {
        // 需要添加 jcenter 否则会提示找不到 gradlePlugin
        jcenter()
        google()
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.20")
    }
}
plugins {
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    mavenCentral()
    google()
    jcenter()
}

dependencies {
    compileOnly(gradleApi())
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.20")
    compileOnly("com.android.tools.build:gradle:4.1.1")
}
kotlinDslPluginOptions {
    experimentalWarning.set(false)
}

gradlePlugin {
    plugins {
        create("version") {
            id = "com.haizhuo.version"
            implementationClass = "VersionConfigPlugin"
        }
    }
}