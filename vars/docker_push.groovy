def call (){
    withCredentials([usernamePassword(
                    credentialsId: 'dockerHubCreds',
                    passwordVariable: 'dockerHubPass',
                    usernameVariable: 'dockerHubUser'
                )]) {
                    sh 'docker login -u $dockerHubUser -p $dockerHubPass'
                    sh 'docker image tag two-tier-flask-app $dockerHubUser/two-tier-flask-app'
                    sh 'docker push $dockerHubUser/two-tier-flask-app:latest'
                }
}