FROM java:8
EXPOSE 9001
ADD build/libs/MessageService-*.jar MessageService.jar
ENTRYPOINT ["java", "-Dsun.net.inetaddr.ttl=0", "-jar", "MessageService.jar"]
