pipeline {
  agent any
  stages {
    stage('build-spring-app') {
      agent any
      steps {
        sh '''mvn package -B -X ./springboot-template
'''
      }
    }

  }
}