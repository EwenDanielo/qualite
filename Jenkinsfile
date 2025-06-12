pipeline {
    agent any

    tools {
        maven 'Maven 3.9.10'
        git 'Default'
    }

    environment {
        SONAR_TOKEN = credentials('sonar-token')
        GITHUB_TOKEN = credentials('github-token')
        PG_CREDS = credentials('pg-credentials')

        POSTGRES_USER = "${PG_CREDS_USR}"
        POSTGRES_PASSWORD = "${PG_CREDS_PSW}"
        POSTGRES_HOST = "postgres-db"
        POSTGRES_DB = 'Library'
        POSTGRES_PORT = '5432'
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        
    post {
        always {
            junit 'biblioflex-api/target/surefire-reports/*.xml'
            cleanWs()
        }
    }
}
