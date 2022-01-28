#!/bin/bash

DEPLOY_SERVER=$DEPLOY_SERVER
SERVER_FOLDER="html-folder-in-server"

# Building React output 
yarn install
yarn run build

echo "Deploying to ${DEPLOY_SERVER}"
scp -r build/ ${DEPLOY_SERVER}:/var/www/html/${SERVER_FOLDER}/

pwd
ls
echo "Finished copying the build files "

