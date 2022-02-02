pipeline {
  agent any
  stages {
    stage('build-spring-app') {
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

    stage('docker-compose-build') {
      steps {
        sh '''
docker-compose build'''
      }
    }

    stage('deploy-kubernetes') {
      steps {
        sh 'kubectl create -f *.yaml'
      }
    }

  }
}