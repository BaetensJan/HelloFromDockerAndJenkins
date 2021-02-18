pipeline {
    agent any
    environment {
        registry = "registry.merilairon.com"
        dockerImage = 'calculator'
    }
    stages {
        stage("Setup permissions") {
            steps {
                sh "chmod +x ./gradlew"
            }
        }
        stage("Compile") {
            steps {
                sh "./gradlew compileJava"
            }
        }
        stage("Package") {
            steps {
                sh "./gradlew build"
           }
        }
    }
}