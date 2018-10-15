FROM java:8
EXPOSE 9001
ADD build/libs/MessageService-*.jar MessageService.jar
ENTRYPOINT ["java", "-jar", "MessageService.jar"]
