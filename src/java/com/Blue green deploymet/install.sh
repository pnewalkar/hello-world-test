#!/bin/bash

# Set this to a bucket owned by you
export STACK_NAME=aws-lambda-hellow-world-deploy-stack

rm -rf build
mkdir build
zip -jr build/hellow_world.zip functions/health_check/*


aws cloudformation package \
    --template-file template.yml \
    --s3-bucket $BUCKET_NAME \
    --output-template-file packaged-template.yml

aws cloudformation deploy \
    --template-file packaged-template.yml \
    --stack-name $STACK_NAME \
    --capabilities CAPABILITY_IAM \
    --parameter-overrides BucketName=$BUCKET_NAME