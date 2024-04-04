def call() {
    // Clone the repository
    git branch: 'main', url: 'https://github.com/Sanchit2323/Test123.git'

    // User Approval
    input message: 'Approve the deployment?', submitter: 'admin,sanchit'

    // Playbook Execution
    ansiblePlaybook(
        credentialsId: '26c1d4a1-4584-469b-a8af-8f5d84ef3842',
        inventory: '/home/sanchit/ansible3/hosts',
        playbook: 'home/sanchit/ansible3/redis.yml'
    )

    // Notification
    emailext(
        subject: 'Ansible Deployment Status',
        body: 'The Ansible deployment has completed.',
        to: 'sanchitkumar0307@gmail.com'
    )
}
