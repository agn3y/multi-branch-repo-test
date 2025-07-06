def buildJar() {
    sh 'mvn clean package'
}

def buildImage(tag) {
    echo "Building Docker image: ${tag}"
    sh "docker build -t ${tag} ."
}

def dockerLogin() {
    withCredentials([
        usernamePassword(
            credentialsId: 'Dockerhub', // Set this ID in Jenkins
            usernameVariable: 'DOCKER_USERNAME',
            passwordVariable: 'DOCKER_PASSWORD'
        )
    ]) {
        sh '''
            echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin
        '''
    }
}

def dockerPush(tag) {
    echo "Pushing Docker image: ${tag}"
    sh "docker push ${tag}"
}

def deployApp() {
    echo "Deploying app..."
    sh "echo Simulating deployment..."
}

return this

