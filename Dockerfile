FROM java:8
EXPOSE 9001
ADD build/libs/MessageService-1.0.0.jar MessageService-1.0.0.jar
ENTRYPOINT ["java", "-jar", "MessageService-1.0.0.jar"]
