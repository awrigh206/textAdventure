pipeline {
   agent any

   stages {
        stage('Get files from Github') 
	    {
         steps {
            //Get code from the right branch of the repository
            git branch: 'refactor', url: 'https://github.com/awrigh206/textAdventure'
             
         }
        }
	  
		stage('Build') { 
			steps 
			{
				sh 'mvn -B -DskipTests clean package' 
			}
		}
		
		stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
   }
}