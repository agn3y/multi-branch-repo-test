def buildJar() {
    echo 'Building the application JAR...'
    sh 'mvn clean package'
}

def buildImage() {
    def registry = "localhost:5000"
    def repo = "agn3y-nexus-repo"
    def appName = "my-java-app"
    def version = params.VERSION ?: "latest"
    def imageName = "${registry}/${repo}/${appName}:${version}"

    echo "Building Docker image: ${imageName}"
    sh "docker build -t ${imageName} ."

    echo "Logging into Nexus Docker registry..."
    sh "echo 9979 | docker login ${registry} -u admin --password-stdin"

    echo "Pushing image to Nexus..."
    sh "docker push ${imageName}"
}

def deployApp() {
    echo "Deploying version ${params.VERSION}"
    // Optional deployment steps
}

return this

