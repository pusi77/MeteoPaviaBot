pipeline {
  agent {
    docker {
      image 'openjdk:8-jdk-slim'
    }

  }
  stages {
    stage('error') {
      steps {
        sh 'mvn -B -DskipTests clean package'
      }
    }

  }
}