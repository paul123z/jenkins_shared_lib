def call(String aws_account_id, String region, String ecr_repoName){

                    def currentDate = new Date().format('yyyyMMdd')
                    def currentTime = new Date().format('HHmmss')
                    def imageTag = "${currentDate}-${currentTime}-${env.BUILD_ID}"
  
sh """
docker build -t ${ecr_repoName} .
docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${imageTag}
"""
}