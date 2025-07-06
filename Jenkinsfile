#!/usr/bin/env groovy

def helper

pipeline {
    agent any
    tools {
        maven 'maven-latest'
    }

    stages {
        stage("init") {
            steps {
                script {
                    helper = load "script.groovy"
                }
            }
        }

        stage("build jar") {
            steps {
                script {
                    helper.buildJar()
                }
            }
        }

        stage("build and push image") {
            steps {
                script {
                    helper.buildImage('agneypatel/test-repoo:1.6')
                    helper.dockerLogin()
                    helper.dockerPush('agneypatel/test-repoo:1.6')
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    helper.deployApp()
                }
            }
        }
    }
}

