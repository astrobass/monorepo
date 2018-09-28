FROM node:alpine as buildserver

ADD package.json .
ADD package-lock.json .
RUN npm install
ENV PATH="./node_modules/.bin:${PATH}"

ADD .babelrc .
ADD webpack.config.js .
ADD ./src ./src
RUN webpack --mode production

FROM nginx:alpine
COPY --from=buildserver ./dist /usr/share/nginx/html

EXPOSE 80
