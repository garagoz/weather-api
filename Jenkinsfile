pipeline {
    agent any

    environment {
        DOCKER_REGISTRY = 'https://index.docker.io/v1/'
        DOCKER_REPO = 'atorayew/weather-api'
        DOCKER_IMAGE = 'weather-api'
        DOCKER_TAG = 'latest' // Or any other tag
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("${env.DOCKER_REPO}/${env.DOCKER_IMAGE}:${env.DOCKER_TAG}")
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry("${env.DOCKER_REGISTRY}", '89cf05cd-5f7a-4210-b32d-acacd7843e7e') {
                        dockerImage.push()
                    }
                }
            }
        }
    }

    post {
        always {
            cleanWs()
        }
    }
}
