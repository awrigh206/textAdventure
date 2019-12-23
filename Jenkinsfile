pipeline {
   agent any

   stages {
      stage('Get files from Github') {
         steps {
            //Get code from the right branch of the repository
            git branch: 'myBranch', url: 'https://github.com/awrigh206/textAdventure'
             
         }
      }
   }
}