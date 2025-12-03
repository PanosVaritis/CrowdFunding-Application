pipeline {
    agent any 

    environment {
        VERSION="1.0.0" 
        IMAGE= "${VERSION}:${BUILD_NUMBER}"
    }

    parameters {
        string (name: 'USERNAME', description:'Provide a username', defaultValue: 'Panagiotis Varitis')
        choice (name: 'ENV', description: 'Select environment', choices: ['develop','stagging','production'])
        booleanParam (name: 'DEBUG', description: 'Param used fro debug purposes', defaultValue: true)
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
        stage ('Print parameters'){
            steps {
                sh """
                echo "The value of username is: ${params.USERNAME}"
                echo "The value of environent is: ${params.ENV}"
                echo "The value of debug is: ${params.DEBUG}"
                """
            }
        }
        stage ('Condition check'){
            steps {
                script {
                    if (params.DEBUG){
                        echo "Running in debug mode"
                    }else {
                        echo "Running in developping mode"
                    }
                    for (int i = 1;i < 3;i++){
                        echo "couner = ${i}"
                    }
                }
            }
        }
    }
}