pipeline {
    agent any 

    environment {
        VERSION="1.0.0",
        IMAGE= ${VERSION}:${BUILD_NUMBER}
    }
    stages{
        stage ('Print message'){
            steps {
                sh '''
                echo "Hello from jenkins"
                '''
                sh '''
                echo "The current directory is $(pwd)"
                '''
                sh '''
                echo "System information: $(uname -a)"
                '''
            }
        }
        stage ('Stage 2'){
            steps {
                sh '''
                echo "The value of the variable is ${VERSION}"
                '''
            }
        }
        stage ('Print default env variables'){
            steps {
                sh'''
                echo "The build number is : ${BUILD_NUMBER}"
                echo "Image is: ${IMAGE}"
                '''
            }
        }
    }
}