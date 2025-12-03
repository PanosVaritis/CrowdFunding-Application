pipeline {
    agent any 

    environment {
        VERSION="1.0.0"
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
    }
}