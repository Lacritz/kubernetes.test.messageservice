# Microservices Example (TimeService)

## About
This project should show the the possibilities '**docker**' and '**kubernetes**' are capable of. 
It could be used as a skeleton for further projects. It will cover each step from building a 'Spring-Boot' 
application in kotlin to running the application in a docker-container. As well as running the **MicroServices** in a 
**docker-compose**. In the last step you can see how to run the services easily in a **kubernetes cluster**, without 
even 
writing a kubernetes file - just by translating the docker-compose via '**kompose**'.

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

## Run 'docker-compose'
Make sure you are in the root directory of the project.
```
cd ./docker && docker-compose up -d
```

