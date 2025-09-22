#!/bin/bash
set -euo pipefail

version=$(sed -ne '10,15 s/<version>\(.*\)<\/version>/\1/p' pom.xml | tr -d '[:space:]')
echo -e "# File generate on build time
app.version-info.version=${version}
app.version-info.date-time=$(date +"%Y-%m-%d %H:%M:%S")
app.version-info.git-commit-branch=$(git describe --tags --exact-match HEAD 2>/dev/null || git branch --show-current 2>/dev/null)
app.version-info.git-commit-hash=$(git rev-parse HEAD)
" > core/src/main/resources/app-version-info.properties
cat core/src/main/resources/app-version-info.properties

./mvnw \
  --fail-fast \
  --update-snapshots \
  --activate-profiles release \
  -DskipTests=true \
  clean package
