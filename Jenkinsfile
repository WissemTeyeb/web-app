pipeline {
  agent any
  stages {
    stage('build-spring-app') {
      agent any
      steps {
        sh '''cd springboot-template
mvn package -B -X 

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
        sh 'echo "on a termin�"'
      }
    }

  }
}