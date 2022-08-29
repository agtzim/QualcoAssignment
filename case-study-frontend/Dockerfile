FROM node:slim AS build
WORKDIR /usr/src/app
COPY . .
RUN npm install
RUN npm run build
### STAGE 2: Run ###
FROM nginx:stable-alpine
COPY nginx.conf /etc/nginx/nginx.conf
COPY --from=build /usr/src/app/dist/case-study-frontend /usr/share/nginx/html