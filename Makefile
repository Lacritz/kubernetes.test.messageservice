compile:
	gradle build
dockerImage: compile
	docker build -t timogruen.com/kubernetes/example/messageservice .
dockerCompose: dockerImage
	cd ./docker && docker-compose up -d
