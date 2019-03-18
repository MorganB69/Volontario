# base image
FROM node:8-alpine as node



WORKDIR /usr/src/app



# install and cache app dependencies
COPY package*.json ./

RUN npm install -g @angular/cli

# add app
COPY . .


# start app
CMD ng serve --host 0.0.0.0
