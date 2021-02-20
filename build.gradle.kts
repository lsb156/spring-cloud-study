import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.4.2"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"

	kotlin("jvm") version "1.4.21"
	kotlin("plugin.spring") version "1.4.21"
}

subprojects {

	group = "com.ssabae"
	version = "0.0.1-SNAPSHOT"


	tasks.withType<JavaCompile> {
		sourceCompatibility = "11"
	}

	extra["springCloudVersion"] = "2020.0.1"

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}

	tasks.withType<Test> {
		useJUnitPlatform()
	}

	repositories {
		mavenCentral()
	}

	buildscript {
		repositories {
			mavenCentral()
		}
	}

	apply {
		plugin("kotlin")
		plugin("kotlin-spring")

		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
	}

}




