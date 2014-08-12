#!/bin/sh

set -e

clean.sh && compile.sh && run-test.sh
