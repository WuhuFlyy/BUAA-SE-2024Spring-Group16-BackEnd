pipeline {
    agent any
    stages {
        stage('拉取代码') {
              steps {
                checkout([$class: 'GitSCM', branches: [[name: '*/microService']],
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
             parallel {
                 stage('构建base模块') {
                     steps {
                         dir('mall-backend/mall-base') {
                             sh label:'', script: 'mvn clean package'
                         }
                     }
                 }
                 stage('构建product模块') {
                     steps {
                         dir('mall-backend/product-service') {
                             sh label:'', script: 'mvn clean package'
                         }
                     }
                 }
                 stage('构建user模块') {
                     steps {
                         dir('mall-backend/user-service') {
                             sh label:'', script: 'mvn clean package'
                         }
                     }
                 }
             }
        }

        stage('构建jar包镜像') {
            steps {
                sh '''
                mv ./mall-backend/mall-base/target/*.jar ./docker/
                mv ./mall-backend/product-service/target/*.jar ./docker/
                mv ./mall-backend/user-service/target/*.jar ./docker/
                docker build --build-arg JAR_FILE=mall-base.jar -f ./Dockerfile_base -t base:${version} ./docker/
                docker build --build-arg JAR_FILE=product-service.jar -f ./Dockerfile_product -t product:${version} ./docker/
                docker build --build-arg JAR_FILE=user-service.jar -f ./Dockerfile_user -t user:${version} ./docker/
                '''
            }
        }

        stage('将软件包部署到Kubernetes') {
             steps {
                   script {
                        withKubeConfig([credentialsId: 'ea808fed-b6e4-4741-821d-3bda9ff974ec']) {
                            sh '''
                            kubectl set image deployment/base-deployment base=base:${version} --record
                            kubectl set image deployment/product-deployment product=product:${version} --record
                            kubectl set image deployment/user-deployment user=user:${version} --record
                            kubectl rollout restart deployment/base-deployment
                            kubectl rollout restart deployment/product-deployment
                            kubectl rollout restart deployment/user-deployment
                            '''
                        }
                   }
             }
        }

        stage('清除空镜像'){
            steps{
                sh 'docker rmi $(docker images -q -f dangling=true) || true'
            }
        }

//         stage('集成测试'){
//             steps{
//                 sh 'newman run se-summer.postman_collection.json'
//             }
//         }
    }
}


