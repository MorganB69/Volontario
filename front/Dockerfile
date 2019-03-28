FROM nginx:1.13.12-alpine

COPY ./dist/front /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
COPY ./localhost.crt /etc/nginx/
COPY ./localhost.key /etc/nginx/
