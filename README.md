# Playframework Webservice

This is a simple Scala and Playframework RESTful API's service template.

This project makes use of GitHub Actions pipeline to build the application docker image and deploy to AWS ECS cluster.

## Prerequisites

- Deploy the ECS cluster using the [Playframework Webservice AWS ECS](https://github.com/rdk823/playframework-demo-aws-ecs)
- Fork this repository
- Set the following GitHub secrets in your repo:
   - AwsAccountId
   - AwsAccessKeyId
   - AwsSecretAccessKey

## Deploying the application

The `test` and `build-image` jobs are triggered each time there is a `push` event. The application is deployed to AWS ECS only when you prefix your commit message with `DEPLOY.

- Edit  `playframework-demo/.github/workflows/sbt.yml` and make sure the environment variables values match the values you provided when deploying your infrastructure using the [Playframework Webservice AWS ECS](https://github.com/rdk823/playframework-demo-aws-ecs)

- Commit your changes by prefixing your commit message with `DEPLOY` to trigger the `deploy` job as well.

- After a few minute visit `http://www.yourdomain.tld` and it will display `Application is up and running`

- Health check endpoint - GET Request to http://www.yourdomain.tld/health - Response : `{"Status":"up"}`
