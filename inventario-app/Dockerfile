FROM node:22 AS node

#set working directory
WORKDIR /app
#install dependencies
#COPY package.json /app/
COPY . /app/
RUN npm install
ARG configuration=production
RUN npm run build
#RUN npm run build --configuration=$configuration
# Serve stage
FROM nginx:alpine
COPY --from=node /app/dist/inventario-app /usr/share/nginx/html/
COPY ./nginx-custom.conf /etc/nginx/conf.d/default.conf
#expose
EXPOSE 80

#command line to run application
#CMD [  "npm", "start"  ]
CMD [ "nginx", "-g", "daemon off;" ]