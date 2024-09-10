// vars/commonBuild.groovy
def call(String serviceName, String dockerfile, String dockerfileName) {
    echo "Building ${serviceName}..."
    
    stage("Build ${serviceName}") {
        sh "mvn clean package -DskipTests -pl ${serviceName} -Pdisable-jib"
    }
    
    stage("Build Docker Image for ${serviceName}") {
        sh "docker build -f ${dockerfile}.Dockerfile -t eren/pia-${dockerfileName}:latest ."
    }
}
