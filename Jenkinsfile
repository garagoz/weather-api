pipeline {
    agent any

    environment {
        DOCKER_REGISTRY = 'https://index.docker.io/v1/'
        DOCKER_REPO = 'atorayew/weather-api'
        DOCKER_IMAGE = 'weather-api'
        DOCKER_TAG = 'latest'
        GIT_CREDENTIALS_ID = 'git_credentials_id'
        DOCKER_CREDENTIALS_ID = 'docker_credentials_id'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Maven Build') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    dockerImage = docker.build("${DOCKER_REPO}/${DOCKER_IMAGE}:${DOCKER_TAG}")
                }
            }
        }

        stage('Login to Docker Registry') {
            steps {
                script {
                    docker.withRegistry(DOCKER_REGISTRY, DOCKER_CREDENTIALS_ID) {
                        // No operation, just login
                    }
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry(DOCKER_REGISTRY, DOCKER_CREDENTIALS_ID) {
                        dockerImage.push()
                        dockerImage.push('latest') // Also tag as latest
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
