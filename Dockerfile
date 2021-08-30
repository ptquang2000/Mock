FROM maven:3.8.2-jdk-11
WORKDIR /usr/mock
COPY ./project ./
CMD ["mvn", "package"]
EXPOSE 8080