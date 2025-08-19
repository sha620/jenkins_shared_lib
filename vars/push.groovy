def call(String call ,String username){
            withCredentials([usernamePassword(
            credentialsId:"${call}",
            usernameVariable:"user",
            passwordVariable:"pass"
                )]){
            sh "docker login -u ${env.user} -p ${env.pass}"
            sh "docker image tag ${username} ${env.user}/${username}"
            sh "docker push ${env.user}/${username}"
                }
}
