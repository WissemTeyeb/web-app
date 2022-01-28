pipeline {
  agent any
  stages {
    stage('build-spring-app') {
      agent any
      steps {
        sh '''cd springboot-template
mvn package -B -X 
cd ..
'''
      }
    }

  }
}