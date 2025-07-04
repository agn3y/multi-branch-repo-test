pipeline {
    agent any

    tools {
        maven 'maven-latest'
    }

    environment {
        IMAGE_NAME = 'agneypatel/test-repoo:1.3'
    }

    stages {
        stage ("Build JAR") {
            steps {
                echo "Building the application..."
                sh 'mvn package'
            }
        }

        stage ("Build Docker Image") {
            steps {
                echo "Building the Docker image..."
                withCredentials([usernamePassword(credentialsId: 'Dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
                    sh "docker build -t $IMAGE_NAME ."
                    sh "echo $PASS | docker login -u $USER --password-stdin"
                    sh "docker push $IMAGE_NAME"
                }
            }
        }

        stage ("Deploy") {
            steps {
                echo "Deploying the application..."
                // Add your deploy commands here
            }
        }
    }
}
