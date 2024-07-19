pipeline {
    agent any

    tools {
        maven 'maven-3.9.8'
    }

    stages {
        stage('Build Maven') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/garagoz/weather-api']])
                sh 'mvn clean install'
            }
        }

        stage('Build Docker image') {
            steps {
                script {
                    sh 'docker build -t atorayew/weather-api .'
                }
            }

        }

        stage('Push docker image') {
            steps {
                script {
                    withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                        sh 'docker login -u atorayew@gmail.com -p ${dockerhubpwd}'
                        sh 'docker push atorayew/weather-api'
                    }
                }
            }

        }
    }
}