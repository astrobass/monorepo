FROM alpine:latest
WORKDIR .
RUN apk update
RUN apk add nodejs nodejs-npm
RUN npm install lerna
RUN lerna run build
RUN lerna run start
