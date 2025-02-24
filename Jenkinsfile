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
		post {
        success {
            emailext subject: 'Build Successful 🎉',
                     body: 'The build was successful! ✅',
                     to: 'rahulsingh6811@gmail.com'
        }
        failure {
            emailext subject: 'Build Failed ❌',
                     body: 'The build has failed! Please check logs. 🔍',
                     to: 'rahulsingh6811@gmail.com'
        }
	}
}