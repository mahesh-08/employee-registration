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
                    bat 'docker build -t cicd-employee .'                                    
            }
        }
        stage ('mysql') {
            steps {
                    bat 'docker run --name=mysql-host --net=host -e MYSQL_ROOT_PASSWORD=root -v /storage/mysql-host/datadir:/var/lib/mysql -d mysql'
            }
        }
        stage ('run') {
            steps {
                    bat 'docker run cicd-employee'
            }
        }   
    }
}