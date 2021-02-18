pipeline {
    agent any
    environment {
        registry = "registry.merilairon.com"
        dockerImage = 'hello-docker-jenkins'
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

        stage("Docker build") {
            steps {
                sh "sudo docker build -t $registry/$dockerImage:$BUILD_NUMBER -t $registry/$dockerImage:latest ."
            }
        }

        stage("Docker push") {
            steps {
                script {
                    sh "sudo docker push $registry/$dockerImage --all-tags"
                }
            }
        }

        stage('Cleaning up') {
            steps {
                sh "sudo docker rmi $registry/$dockerImage:$BUILD_NUMBER"
            }
        }
    }
}