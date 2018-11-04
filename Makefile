compile:
	gradle build

dockerImage: compile
	docker build -t timogruen.com/kubernetes/example/messageservice:1.0.0 .

dockerCompose: dockerImage
	cd ./docker && docker-compose up -d

kubectlDeleteServices:
	kubectl delete services messageservice timeservice

kubectlDeleteDeployment:
	kubectl delete deployments messageservice \
	&& kubectl delete deployments timeservice


kubectlDeleteAll: kubectlDeleteServices  kubectlDeleteDeployment

komposeUp:
	cd ./docker && kompose up
