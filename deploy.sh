#!/bin/sh

set -e

clean.sh && compile.sh && deploy-project.sh
