#!/bin/sh

echo "RUN-TEST START"

CLASSPATH="target/classes;target/test-classes"

[[ -d lib-runtime ]] && for RUNTIMEFILE in lib-runtime/*.jar; do

CLASSPATH_RUNTIME="$CLASSPATH;$RUNTIMEFILE"

done

java -classpath "$CLASSPATH_RUNTIME" com.util.XuShuangShuangJunit "com.xu.ReflectServletTest"

RETVAL=$?

echo "RUN-TEST DONE"
