pipeline {
    agent any

    environment {
        IMAGE_NAME = "bookmycar"
        CONTAINER_NAME = "bookmycar-app"
        PORT = "8082"
    }

    stages {

        stage('Checkout') {
            steps {
                git 'https://github.com/Masthan0/bookmycar.git'
            }
        }

        stage('Build') {
            steps {
                bat 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test'
            }
        }

        stage('Docker Build') {
            steps {
                bat 'docker build -t bookmycar .'
            }
        }

        stage('Stop Old Container') {
            steps {
                bat '''
                docker rm -f bookmycar-app || exit 0
                '''
            }
        }

        stage('Run New Container') {
            steps {
                bat '''
                docker run -d -p 8082:8082 --name bookmycar-app bookmycar
                '''
            }
        }
    }
}
