#!/bin/bash
set -euo pipefail

./mvnw \
  --fail-fast \
  org.jacoco:jacoco-maven-plugin:prepare-agent \
  org.jacoco:jacoco-maven-plugin:prepare-agent-integration \
  -DCI=true \
  -Daspectj.skip=true \
  -Dassembly.skipAssembly=true \
  -Dfailsafe.printSummary=true \
  -Dfailsafe.skipAfterFailureCount=1 \
  -Dsurefire.printSummary=true \
  -Dsurefire.skipAfterFailureCount=1 \
  verify

./mvnw \
  org.jacoco:jacoco-maven-plugin:report \
  -DCI=true
