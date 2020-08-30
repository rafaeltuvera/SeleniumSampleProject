pipeline {
    agent any
    stages {
        stage('Execute test Automation scripts') {
        	steps {
        	  maven(maven : 'MAVEN_HOME')
	          		bat 'mvn clean install'
	        }
        	
        }
    }
}