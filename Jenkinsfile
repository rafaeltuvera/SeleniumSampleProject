pipeline {
    agent any
    stages {
        stage('Build') {
        	steps {
	          		bat "mvn clean install"
	        }
        	
        }
        
        stage('Execute test Automation scripts') {
        	steps {
	          		bat "mvn clean test"
	        }
        	
        }
    }
    tools {
      maven 'MAVEN_HOME'
  }
}
