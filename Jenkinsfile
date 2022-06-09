pipeline {
    agent any
    stages {
    	stage ('mvn') {
            steps {               
                    bat 'mvn clean install'                                    
            }
        }
        stage ('build') {
            steps {               
                    bat 'docker compose up'                                    
            }
        }    
    }
}