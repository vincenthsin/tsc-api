# tsc-api

### 1. build jar:
mvn clean package -Dmaven.test.skip=true

### 2. build image:
docker build --build-arg JAR_FILE=target/*.jar -t ikigai-team/tsc-api .

### 3. run it in local:
docker-compose up

### Check it:
http://localhost:1024/tsc/api/actuator/health
http://localhost:1024/tsc/api/swagger-ui/index.html