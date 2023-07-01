// def call(String project, String ImageTag, String hubUser){

//     sh """
//     echo "------ TRIVY STEP RUNNING NOW -------"
//     trivy image ${hubUser}/${project}:latest > scan.txt
//     cat  scan.txt
//     echo "------ TRIVY STEP FINALIZED -------"
//     """
// }



def call(String aws_account_id, String region, String ecr_repoName){

sh """
trivy image ${aws_account_id}.dkr.ecr.${region}.amazonaws.com/${ecr_repoName}:latest > scanECR.txt
cat scanECR.txt
"""
}