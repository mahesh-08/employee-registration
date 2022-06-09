pipeline {
    agent any
    stages {
        stage ('build app') {
            steps {               
                    sh 'mvn clean install'                                    
            }
        }
        stage ('build') {
            steps {
                    sh 'docker-compose up'
            }
        }
        
    }
}