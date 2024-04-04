def call() {
    // Clone the repository
    git branch: 'main', url: 'https://github.com/Sanchit2323/Test123.git'

    // User Approval
    input message: 'Approve the deployment?', submitter: 'admin,sanchit'

    // Playbook Execution
    ansiblePlaybook(
        inventory: 'hosts',
        playbook: 'redis.yml'
    )

    // Notification
    emailext(
        subject: 'Ansible Deployment Status',
        body: 'The Ansible deployment has completed.',
        to: 'sanchitkumar0307@gmail.com'
    )
}
