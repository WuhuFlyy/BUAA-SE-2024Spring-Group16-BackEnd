pipeline {
    agent any
    stages {
         stage('拉取代码') {
              steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/master']],
                doGenerateSubmoduleConfigurations: false, extensions: [], submoduleCfg: [],
                userRemoteConfigs: [[credentialsId: 'e82aa310-3ca3-44b6-8493-d820df7c8f6c', url:
                'https://github.com/WuhuFlyy/BUAA-SE-2024Spring-Group16-BackEnd']]])
              }
         }

        stage('编译构建') {
            steps {
                sh label: '', script: 'mvn clean package'
            }
        }

        stage('项目部署') {
            steps {
                deploy adapters: [tomcat8(credentialsId: '6bb34192-388e-4d16-9a31-d9989e610120',
                path: '', url: 'http://localhost:8081')], contextPath: null,
                war: 'target/*.war'
            }
        }
    }
}