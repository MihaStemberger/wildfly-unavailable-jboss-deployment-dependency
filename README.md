# Unavailable dependency

### Credentials

* 26.1.3.Final Wildfly admin (http://localhost:9990/): admin / admin
* 20.0.1.Final Wildfly admin (http://localhost:9991/): admin / admin

## Usage

**1. Build maven project**
```bash
mvn clean install
```

**2. Start docker containers**
```bash
docker compose up
```

**3. Deploy artifacts to wildfly 20.0.1.Final container**
```bash
mvn wildfly:deploy-only -Pworking-wildfly
```
This deployment is all good.

**4. Deploy artifacts to wildfly 26.1.3.Final container**
```bash
mvn wildfly:deploy-only -Pnon-working-wildfly
```

`war-deployment` will in this case fail with 
`Caused by: java.lang.ClassNotFoundException: com.mihas.wildfly.examples.unresolved.dependency.special.TestUtil from [Module "deployment.war-deployment-1.0.0-SNAPSHOT.war" from Service Module Loader]`

## Deploying changes
If any changes are made to source code use: `mvn clean install wildfly:deploy-only`
with a specified profile `-Pnon-working-wildfly` or `-Pworking-wildfly`

If any changes are made to a DockerFile:
1. remove running containers:
    ```bash 
    docker compose down
    ```
2. rebuild the project:
    ```bash 
    mvn clean install
    ```
3. build new docker images: 
    ```bash 
   docker compose build
    ```
4. start docker containers: 
    ```bash 
   docker compose up
    ```
