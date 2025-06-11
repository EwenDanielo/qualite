pipeline {
    agent any

    tools {
    maven 'Maven 3.9.10'
  }

    environment {
        SONAR_TOKEN = credentials('sonar-token')
        GITHUB_TOKEN = credentials('github-token')
        POSTGRES_USER = credentials('pg-user')
        POSTGRES_PASSWORD = credentials('pg-password')
        POSTGRES_DB = 'qualite'
        POSTGRES_PORT = '5433'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/EwenDanielo/qualite.git', credentialsId: 'github-token'
            }
        }

        stage('Build Backend') {
            steps {
                dir('biblioflex-api') {
                    sh 'mvn clean verify'
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
                dir('.') {
                    sh '''
                    mvn sonar:sonar \
                    -Dsonar.projectKey=EwenDanielo_qualite \
                    -Dsonar.organization=ewendanielo-1 \
                    -Dsonar.host.url=https://sonarcloud.io \
                    -Dsonar.login=${SONAR_TOKEN} \
                    -Dsonar.sources=biblioflex-api/src,biblioflex-ui/src \
                    -Dsonar.java.binaries=biblioflex-api/target/classes \
                    -Dsonar.language=java,js,ts
                    '''
                }
            }
        }

        stage('Dependency Check (OWASP)') {
            steps {
                dir('biblioflex-api') {
                    // Exécute le scan OWASP Dependency-Check
                    sh 'dependency-check.sh --project "qualite-api" --scan . --format HTML --out dependency-check-report'
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'biblioflex-api/dependency-check-report/*.html', allowEmptyArchive: true
                }
            }
        }

        stage('Docker Compose up DB') {
            steps {
                dir('.') {
                    sh 'docker compose up -d postgres-db'
                }
            }
        }
    }
    
    post {
        always {
            junit 'biblioflex-api/target/surefire-reports/*.xml'
            cleanWs()
        }
    }
}
