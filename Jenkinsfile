pipeline {
    agent any
    stages {
        stage('Execute test Automation scripts') {
        	steps {
        	  	maven(maven : 'Maven_3.6.2')
	          		bat 'mvn clean install'
	        }
        	
        }
    }
}