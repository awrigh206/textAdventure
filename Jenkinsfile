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
				sh 'pwd'
				sh 'ls'
                sh 'mvn test'
            }
        }
		
		    stage('Build image') {
				/* This builds the actual image; synonymous to
				 * docker build on the command line */

				/*app = docker.build("awrigh206/text_adventure")*/
				
				steps
				{
					sh 'sudo docker build . -t awrigh206/text_adventure'
				}
				
				
			}


		stage('Push image') {
			/* push the created image onto docker hub so that it can be accessed by other services*/
			
			steps
			{
					sh 'sudo docker push awrigh206/text_adventure:latest'
			}
			
		}
   }
}

