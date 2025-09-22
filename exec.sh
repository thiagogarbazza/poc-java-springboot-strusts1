
docker compose --project-name poc-spring-struts1-dev --file .config/dev/docker-compose.yml up
exit 0;

docker compose --project-name poc-spring-struts1-job --file .config/dev/docker-compose-job.yml down --remove-orphans
docker compose --project-name poc-spring-struts1-web --file .config/dev/docker-compose-web.yml down --remove-orphans
if [[ -n "$(docker image ls -aqf=reference='*/*/poc-springboot-strusts1/*')" ]]  then
  echo "Removing old images"
  docker image ls -f=reference='*/*/poc-springboot-strusts1/*'
  docker image rm -f $(docker image ls -aqf=reference='*/*/poc-springboot-strusts1/*')
fi

./mvnw clean package -DskipTests=true

#docker compose --project-name poc-spring-struts1-dev --file .config/dev/docker-compose-job.yml up --force-recreate --remove-orphans --abort-on-container-failure

docker compose --project-name poc-spring-struts1-dev --file .config/dev/docker-compose-web.yml up --force-recreate --remove-orphans --abort-on-container-failure