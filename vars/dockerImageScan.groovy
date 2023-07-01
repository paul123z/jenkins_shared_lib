def call(String project, String ImageTag, String hubUser){

    sh """
    echo "------ TRIVY STEP RUNNING NOW -------"
    trivy image ${hubUser}/${project}:latest > scan.txt
    cat  scan.txt
    echo "------ TRIVY STEP FINALIZED -------"
    """
}