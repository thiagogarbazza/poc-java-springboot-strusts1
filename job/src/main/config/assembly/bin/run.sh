#!/bin/bash
set -uo pipefail

if [[ "${WAIT_TO_START:-0}" -gt 0 ]]; then
  echo "Waiting for ${WAIT_TO_START} seconds before starting..."
  sleep "${WAIT_TO_START}"
fi

java \
  -classpath "/app/resources:/app/lib/*" \
  "${JAVA_OPTS:-}" \
  com.github.thiagogarbazza.pocs.app.job.ApplicationJob "${JOB_NAME:-}" \
  2>&1
EXIT_STATUS=${PIPESTATUS[0]}

if [[ "${WAIT_TO_END:-0}" -gt 0 ]]; then
  echo "Waiting for ${WAIT_TO_END} seconds before stopping..."
  sleep "${WAIT_TO_END}"
fi

echo "exit-status: ${EXIT_STATUS}"
exit "${EXIT_STATUS}"