compile:
	gradle build

dockerImage: compile
	docker build -t timogruen.com/kubernetes/example/messageservice:1.0.0 .

dockerCompose: dockerImage
	cd ./docker && docker-compose up -d

kubectlDeleteServices:
	kubectl delete services messageservice \
  && kubectl delete services timeservice

kubectlDeleteDeployment: kubectlDeleteServices
	kubectl delete deployments messageservice \
	&& kubectl delete deployments timeservice

komposeUp:
	cd ./docker && kompose up
