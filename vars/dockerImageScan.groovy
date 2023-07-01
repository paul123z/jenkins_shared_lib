def call(String project, String ImageTag, String hubUser){

    sh """
    echo "------ TRIVY STEP RUNNING NOW -------"
    trivy image ${hubUser}/${project} ${hubUser}/${project}:latest > scan.txt
    cat  sca.txt
    echo "------ TRIVY STEP FINALIZED -------"
    """
}