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

//         stage('构建数据库镜像') {
//             steps {
//                 script {
//                     sh '''mv ./mall.sql ./docker/
//                     docker build -f ./docker/Dockerfile_mysql -t mall-mysql:${version} ./docker/'''
//                 }
//             }
//         }
//
//         stage('将数据库部署到k8s'){
//             steps{
//                  withKubeConfig([credentialsId: 'ea808fed-b6e4-4741-821d-3bda9ff974ec']) {
//                     sh '''
//                     kubectl set image deployment/mall-mysql-deployment mysql=mall-mysql:${version} --record
//                     kubectl rollout status deployment/mall-mysql-deployment
//                     '''
//                 }
//             }
//         }

        stage('编译构建') {
             steps {
                 sh label: '', script: 'mvn clean package'
             }
        }

        stage('构建jar包镜像') {
            steps {
                sh '''mv ./target/*.jar ./docker/
                docker build --build-arg JAR_FILE=mall-0.0.1-SNAPSHOT.jar -f ./docker/Dockerfile -t mall:${version} ./docker/
                '''
            }
        }

        stage('将软件包部署到Kubernetes') {
             steps {
                   script {
                        withKubeConfig([credentialsId: 'ea808fed-b6e4-4741-821d-3bda9ff974ec']) {
                            sh '''
                            kubectl delete -f deployment.yaml || true
                            docker rmi -f mall:${version} || true
                            docker build -t mall:${version} .
                            kubectl apply -f deployment.yaml ||true
                            kubectl rollout restart deployment/mall-deployment
                            '''
                        }
                   }
             }
        }
    }
}


