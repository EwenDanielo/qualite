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

            stage('Docker Compose up DB') {
            steps {
                dir('.') {
                    sh '''
                    if [ $(docker ps -a -q -f name=qualite_postgres) ]; then
                        docker rm -f qualite_postgres
                    fi
                    docker-compose up -d postgres-db
                    sleep 10
                    '''
                }
            }
        }

        stage('Build Frontend') {
            steps {
                dir('biblioflex-ui') {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('SonarCloud Analysis') {
            steps {
                dir('biblioflex-api') {
                    sh '''
                    mvn sonar:sonar \
                    -Dsonar.projectKey=EwenDanielo_qualite \
                    -Dsonar.organization=ewendanielo-1 \
                    -Dsonar.host.url=https://sonarcloud.io \
                    -Dsonar.login=${SONAR_TOKEN} \
                    -Dsonar.sources=../biblioflex-api/src,../biblioflex-ui/src \
                    -Dsonar.java.binaries=target/classes \
                    -Dsonar.language=java,js,ts
                    '''
                }
            }
        }

        stage('Dependency Check (OWASP)') {
            steps {
                dir('biblioflex-api') {
                    sh 'dependency-check.sh --project "qualite-api" --scan . --format HTML --out dependency-check-report'
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'biblioflex-api/dependency-check-report/*.html', allowEmptyArchive: true
                }
            }
        }
    }
}
