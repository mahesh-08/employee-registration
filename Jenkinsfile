pipeline {
    agent any
    stages {
        stage ('build') {
            steps {               
                    sh 'docker build -t cicd-employee .'                                    
            }
        }
        stage ('mysql') {
            steps {
                    sh 'docker run --name=mysql-host --net=host -e MYSQL_ROOT_PASSWORD=root -v /storage/mysql-host/datadir:/var/lib/mysql -d mysql'
            }
        }
        stage ('run') {
            steps {
                    sh 'docker run cicd-employee'
            }
        }
        
    }
}