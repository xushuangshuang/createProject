#!/bin/sh

set -e

echo "COMPILE START"

mkdir -p target/classes target/test-classes 

CLASSPATH="target/class;target/test-classes"

[[ -d lib ]] && for WEBFILE in lib/*.jar; do

CLASSPATH_WEB="$CLASSPATH;$WEBFILE"

done

CLASSPATH_TEST=$CLASSPATH_WEB

[[ -d lib-test ]] && for TESTFILE in lib-test/*.jar; do

CLASSPATH_TEST="$CLASSPATH_TEST;$TESTFILE"

done

CLASSPATH_RUNTIME=$CLASSPATH_TEST

[[ -d lib-runtime ]] && for RUNTIMEFILE in lib-runtime/*.jar; do

CLASSPATH_RUNTIME="$CLASSPATH_RUNTIME;$RUNTIMEFILE"

done

find src/main/java/ -maxdepth 3 -type f | xargs javac -d target/classes/ -Xlint:unchecked -classpath "$CLASSPATH_WEB"

find src/test/java/ -maxdepth 3 -type f | xargs javac -d target/test-classes -classpath "$CLASSPATH_TEST"

echo "COMPILE DONE"
