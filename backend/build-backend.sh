#!/usr/bin/env sh

set -e

cd backend
./gradlew clean build -x test
