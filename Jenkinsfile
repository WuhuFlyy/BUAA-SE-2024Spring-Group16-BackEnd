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

        stage('数据库备份') {
            steps {
                script {
                    docker.image('mysql:latest').inside {
                        sh 'mysqldump -h localhost -u root -p 2857709015yzhzs mall > mall.sql'
                    }
                }
            }
        }
    }
}








//
//         stage('编译构建') {
//             steps {
//                 sh label: '', script: 'mvn clean package'
//             }
//         }
//
//         stage('项目部署') {
//             steps {
//                 sh '''mv ./target/*.jar ./docker/
//                 docker build --build-arg JAR_FILE=mall-0.0.1-SNAPSHOT.jar -t mall:${version} ./docker/'''
//             }
//         }
//
//         stage('部署到Kubernetes') {
//              steps {
//                    script {
//
//                             withKubeConfig([credentialsId: 'ea808fed-b6e4-4741-821d-3bda9ff974ec']) {
//                                 sh '''
//                                 kubectl set image deployment/mall-deployment mall=mall:${version} --record
//                                 kubectl rollout status deployment/mall-deployment
//                                 '''
//                             }
//                    }
//              }
//         }
//     }
// }