plugins {
    id("java")
    id("application")
    id("org.openjfx.javafxplugin") version "0.1.0"
}

group = "br.com.cabelo"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

//    maven {
//        url = uri("../MeuLog")
//    }
    flatDir { dirs ("libs") }
}

javafx {
    version = "21"
    modules = listOf("javafx.controls", "javafx.fxml")
}

dependencies {

    implementation(project(":MeuLog"))
    implementation(project(":MeuFramework"))

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}