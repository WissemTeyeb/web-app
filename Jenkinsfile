pipeline {
  agent any
  stages {
    stage('build-spring-app') {
      agent any
      steps {
        sh '''cd springboot-template
mvn package -B -X 
ls 
ls target 
'''
      }
    }

    stage('build-react-app') {
      steps {
        sh '''cd react-template

yarn install

yarn run build'''
      }
    }

    stage('final-stage') {
      steps {
        sh '''
docker image rm 70461e8943d9/spring-boot
docker-compose build'''
      }
    }

  }
}