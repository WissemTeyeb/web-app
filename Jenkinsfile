pipeline {
  agent any
  stages {
    stage('build-spring-app') {
      agent {
        docker {
          image 'maven:3.5.0'
        }
      }
      steps {
        sh '''cd springboot-template
mvn install
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
docker image ls
docker-compose build'''
      }
    }

  }
}
