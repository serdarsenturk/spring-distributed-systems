# Distributed Systems

#### Run Spring and Maven Applications in CLI
>Run with classpath
```
`java -cp target/Example-1.0.0-SNAPSHOT.jar org.example.app.Example`
                        OR
`java -cp /Users/serdar/workdir/github/demoSpring/Mainweb/target/classes:lib/* org.example.app.Example -jar target/Example-1.0.0-SNAPSHOT.jar`
```
>Run with env_var
```
`java -DENV_VAR="EXAMPLE" -cp target/App-1.0-SNAPSHOT.jar org.example.app.App`
```

#### Docker Build and Run an application manually
```
`mvn clean package`
`docker build --tag{tagnaME} .
`docker run -d -p {PORT:PORT} -t {imageName or ImageId}
```

#### Docker-compose.yml start with env
`docker-compose --env-file .env.development up`

#### example /.env.development
```
HELLO_VER=2.4
LOGGER_VER=1.4
CONSOLE1_VER=1.8
```

##### example /console1/.env.development
```
RABBITMQ_CONN=
```

##### example /logger/.env.development
```
RABBITMQ_CONN=
```

##### example /hello/.env.development
```
RABBITMQ_CONN=
```

### Control to Redis with interactive mode
```
`docker container exec -it containerID sh/zsh/bash`
```