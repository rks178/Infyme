pipeline{
	agent any
	
	stages{
		stage('Checkout code'){
			steps{
				git url: 'https://github.com/rks178/Infyme.git',
			branch:'main'
			}
			
		}
		stage('Build project'){
			steps{
				sh 'mvn clean compile'
			}
			
		}
		stage('Run selenium test'){
			steps{
				sh 'mvn test -Dheadless=true'
			}
			
		}
		stage('Publish Test Results'){
			steps {
                junit '**/target/surefire-reports/*.xml'
            }
		}
	}
}