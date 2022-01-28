pipeline {
  agent any
  stages {
    stage('build-spring-app') {
      steps {
        sh '''mvn package -B -X ./springboot-template
'''
      }
    }

  }
}