#!/usr/bin/env bash

eval $(aws ecr get-login --registry-ids ${AWS_ECR_ACCOUNT_ID} --region $AWS_ECR_REGION --no-include-email)

REPOSITORY_URI=${AWS_ECR_ACCOUNT_ID}.dkr.ecr.${AWS_ECR_REGION}.amazonaws.com/${PROJECT}/${APPLICATION_NAME}

GIT_SHORT_SHA=$(echo ${GITHUB_SHA} | cut -c1-7)

docker tag api:1.0.0 ${REPOSITORY_URI}:${GIT_SHORT_SHA}

docker tag api:1.0.0 ${REPOSITORY_URI}:latest

docker push ${REPOSITORY_URI}:${GIT_SHORT_SHA}

docker push ${REPOSITORY_URI}:latest

aws ecs update-service --cluster ${PROJECT}-${APPLICATION_NAME}-ecs-cluster --service ${PROJECT}-${APPLICATION_NAME} --force-new-deployment
