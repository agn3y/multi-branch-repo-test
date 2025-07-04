def buildJar() {
    echo 'building the application...'
    sh 'mvn package' 	
} 

def buildImage() {
    echo "Building the Docker image..."
    withCredentials([usernamePassword(credentialsId: 'Dockerhub', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        sh "docker build -t \"$IMAGE_NAME\" ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push \"$IMAGE_NAME\""
    }
} 

def deployApp() {
    echo 'deploying the application...'
    echo "deploying version ${params.VERSION}"
} 

return this

