# MicroServices Example (MessageService)

## About
This project should show the the possibilities '**docker**' and '**kubernetes**' are capable of. 
It could be used as a skeleton for further projects. It will cover each step from building a 'Spring-Boot' 
application in kotlin to running the application in a docker-container. As well as running the **MicroServices** in a 
**docker-compose**. In the last step you can see how to run the services easily in a **kubernetes cluster**, without 
even 
generating kubernetes files - just by translating the docker-compose via '**kompose**'.

## Preparation
### Checkout both services:

1) [MessageService](https://github.com/Lacritz/kubernetes.test.messageservice)
2) [TimeService](https://github.com/Lacritz/kubernetes.test.timeservice)

### Install the following software:
1. [Kotlin](https://kotlinlang.org/docs/tutorials/command-line.html)
2. [Docker](https://docs.docker.com/install/)
3. [Docker-Compose](https://docs.docker.com/compose/install/) 
4. [MiniKube](https://kubernetes.io/docs/tasks/tools/install-minikube/)
5. [kubectl](https://kubernetes.io/docs/tasks/tools/install-kubectl/)

# Installation

## Compile
```
gradle build
```

## Build Docker Image
```
docker build -t timogruen.com/kubernetes/example/messageservice .
```

## Run Docker Images
Make sure you are in the root directory of the project.
You can use either one of those: 
```
cd ./docker && docker-compose up -d
```
```
docker run timogruen.com/kubernetes/example/timeservice
docker run timogruen.com/kubernetes/example/messageservice
```

#### Access the services
To curl the services just use: 
```
curl 127.0.0.1:9001/api/v1/message/{text}
```
```
curl 127.0.0.1:9000/api/v1/time
```

_Note: This will work using docker, but not while using minikube_

## Run inside MiniKube
Make sure minikube is started and running properly. Since this can be rather handy, keep in mind, that this step 
could take some time.  
```
minikube start
```
Docker has to push his images to the minikube instance - to add them into path, use the following:
```
eval $(minikube docker-env)
docker build -t timogruen.com/kubernetes/example/messageservice:1.0.0 .
```
_Note: that you publish the TimeService as well!_


#### Access the services 
To connect to the VM running minikube use:
```
minikube ssh
```
Now you are able to access the services using:
```
curl 127.0.0.1:9001/api/v1/message/{text}
```

#### Scale your services
TDB!

#### Stop Minikube
Since minikube mimics a complete kubernetes cluster, make sure to stop minikube, once you are finished.
```
minikube stop
```
