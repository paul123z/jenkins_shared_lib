def call(String aws_account_id, String region, String ecr_repoName){

    def dateFormat = new SimpleDateFormat("yyyyMMdd-HHmmss")
    def currentDate = dateFormat.format(new Date())
    def imageTag = "${currentDate}-${env.BUILD_ID}"

sh """
docker build -t ${ecr_repoName} .
docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
docker tag ${ecr_repoName}:latest ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${imageTag}
"""
}