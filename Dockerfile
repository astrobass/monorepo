FROM alpine:latest
WORKDIR .
RUN npm install lerna
RUN lerna run build
RUN lerna run start
