def buildJar() {
    sh 'mvn clean package'
}

def buildImage(tag) {
    sh "docker build -t ${tag} ."
}

def dockerLogin() {
    sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
}

def dockerPush(tag) {
    sh "docker push ${tag}"
}

def deployApp() {
    sh "echo Deploying app..."
}

return this

