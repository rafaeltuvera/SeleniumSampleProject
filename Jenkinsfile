pipeline {
    agent any
    stages {
        stage('Execute test Automation scripts') {
        	steps {
	          		bat "mvn clean install"
	        }
        	
        }
    }
    tools {
      maven 'MAVEN_HOME'
  }
}
