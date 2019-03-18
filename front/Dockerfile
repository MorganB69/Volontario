# base image
FROM node:8-alpine as node

# set working directory
RUN mkdir /src/app
WORKDIR /src/app

# add `/usr/src/app/node_modules/.bin` to $PATH
ENV PATH /src/app/node_modules/.bin:$PATH

# install and cache app dependencies
COPY /package.json /front/src/app/package.json
RUN npm install
RUN npm install -g @angular/cli

# add app
COPY . /src/app

# start app
CMD ng serve
