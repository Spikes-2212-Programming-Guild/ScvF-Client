plugins {
    `java-library`
}

repositories {
    maven {
        url = uri("http://first.wpi.edu/FRC/roborio/maven/release/")
    }
}

val ntcoreVersion by extra("2019.2.1")

dependencies {
    api("edu.wpi.first.ntcore:ntcore-java:$ntcoreVersion")
}
