FROM nginx:1.15-alpine

COPY ./dist/OurSofkaProjects-Front /usr/share/nginx/html
COPY ./nginx.conf /etc/nginx/conf.d/default.conf
COPY ./auth_config.json .

EXPOSE 80
