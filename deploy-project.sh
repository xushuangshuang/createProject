#!/bin/sh

echo "DEPLOY-PROJECT START"

read -p "PLEASE INPUT PROJECT NAME :" PROJECT_NAME

if [[ "$PROJECT_NAME" = "" ]]; then

    echo "NO PROJECT NAME"

    exit
fi

mkdir -p $CATALINA_HOME/webapps/$PROJECT_NAME

cp -r src/main/webapp/* $CATALINA_HOME/webapps/$PROJECT_NAME

cp -r target/classes $CATALINA_HOME/webapps/$PROJECT_NAME/WEB-INF/

cp -r lib $CATALINA_HOME/webapps/$PROJECT_NAME/WEB-INF/

RETVAL=$?

echo "DEPLOY-PROJECT DONE"
