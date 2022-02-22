FROM ubuntu:latest

MAINTAINER Kuang He "kuang.he@gmail.com"

RUN apt-get update && apt-get install -y openjdk-8-jdk

WORKDIR /usr/local/bin

ADD target/wavelet-generation-app.jar .

ENTRYPOINT ["java", "-jar", "target/wavelet-generation-app.jar"]

