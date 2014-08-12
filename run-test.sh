#!/bin/sh

echo "RUN-TEST START"

CLASSPATH_RUNTIME="target/classes;target/test-classes"

[[ -d lib-runtime ]] && for RUNTIMEFILE in lib-runtime/*.jar; do

CLASSPATH_RUNTIME="$CLASSPATH_RUNTIME;$RUNTIMEFILE"

done

echo "$CLASSPATH_RUNTIME"

java -classpath "$CLASSPATH_RUNTIME" com.util.XuShuangShuangJunit "com.xu"

echo "RUN-TEST DONE"
