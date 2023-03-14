# Unavailable dependency

### Credentials

* Wildfly admin (http://localhost:9990/): admin / admin

## Usage

**1. Build maven project**
```bash
mvn clean install
```

**2. Start docker containers**
```bash
docker compose up
```

**3. Deploy artifacts**
```bash
mvn wildfly:deploy-only
```

`war-deployment` will fail with `Caused by: java.lang.ClassNotFoundException: com.mihas.wildfly.examples.unresolved.dependency.special.TestUtil from [Module "deployment.war-deployment-1.0.0-SNAPSHOT.war" from Service Module Loader]`

## Deploying changes
If any changes are made to source code use: `mvn clean install wildfly:deploy-only`

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
   docker comose up
    ```
