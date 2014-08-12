#!/bin/sh

echo "RUN-TEST START"

CLASSPATH="target/classes;target/test-classes"

[[ -d lib-runtime ]] for RUNTIMEFILE in lib-runtime/*.jar; do

CLASSPATH_RUNTIME="$CLASSPATH;$RUNTIMEFILE"

done

read -p "PLEASE INPUT TEST CASE PACKAGE :" PACKAGE

if [[ "$PACKAGE" = "" ]]; then

    echo "PACKAGE IS NULL"

    exit
fi

java -classpath "$CLASSPATH_RUNTIME" com.util.XuShuangShuangJunit $PACKAGE

RETVAL=$?

echo "RUN-TEST DONE"
