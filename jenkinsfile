pipeline {
    agent any
    
    stages {
        stage('Execute test Automation scripts') {
        	steps {
	            withMaven(maven : 'MAVEN_HOME'){
	                sh "mvn clean install"                
	            }

	        }
        	
        }
    }
}