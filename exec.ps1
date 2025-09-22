param(
  [string]$action
)

switch ($action) {

  'job' {
      docker compose --project-name poc-spring-struts1-job --file .config\dev\docker-compose-job.yml up
  }

  'web' {
    docker compose --project-name poc-spring-struts1-web --file .config\dev\docker-compose-web.yml up
  }

  default {
    docker compose --project-name poc-spring-struts1 --file .config\dev\docker-compose.yml up
  }
}
