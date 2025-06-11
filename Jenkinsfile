pipeline {
    agent any

    tools {
    maven 'Maven 3.9.10'
  }

    environment {
        SONAR_TOKEN = credentials('sonar-token')
        GITHUB_TOKEN = credentials('github-token')
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'master', url: 'https://github.com/EwenDanielo/qualite.git', credentialsId: 'github-token'
            }
        }

        stage('Build Backend') {
            steps {
                dir('qualite/biblioflex-api') {
                    sh 'mvn clean verify'
                }
            }
        }

        stage('Build Frontend') {
            steps {
                dir('qualite/biblioflex-ui') {
                    sh 'npm install'
                    sh 'npm run build'
                }
            }
        }

        stage('SonarCloud Analysis') {
            steps {
                dir('qualite') {
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
                dir('qualite/biblioflex-api') {
                    // Exécute le scan OWASP Dependency-Check
                    sh 'dependency-check.sh --project "qualite-api" --scan . --format HTML --out dependency-check-report'
                }
            }
            post {
                always {
                    archiveArtifacts artifacts: 'qualite/biblioflex-api/dependency-check-report/*.html', allowEmptyArchive: true
                }
            }
        }

        stage('Docker Compose up DB') {
            steps {
                dir('qualite') {
                    sh 'docker compose up -d postgres-db'
                }
            }
        }
    }
    
    post {
        always {
            junit 'qualite/biblioflex-api/target/surefire-reports/*.xml'
            cleanWs()
        }
    }
}
