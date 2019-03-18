# base image
FROM node:8-alpine as node

# set working directory
RUN mkdir /front/src/app
WORKDIR /front/src/app

# add `/usr/src/app/node_modules/.bin` to $PATH
ENV PATH /front/src/app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY front/package.json /front/src/app/package.json
RUN npm install
RUN npm install -g @angular/cli

# add app
COPY . /front/src/app

# start app
CMD ng serve
