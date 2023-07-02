def call(String aws_account_id, String region, String ecr_repoName){
// docker rmi ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${ImageTag}


    sh """
    docker rmi ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest
    docker rmi ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:${imageTag}
    """
}