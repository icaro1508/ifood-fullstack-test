FROM node:lts-buster as build

ARG REACT_APP_API_BASE_URL
ENV REACT_APP_API_BASE_URL=$REACT_APP_API_BASE_URL
RUN mkdir /tmp/front-end
WORKDIR /tmp/front-end

COPY . .

RUN yarn install && \
    yarn build && \
    rm -rf node_modules

FROM tomcat:9.0

COPY --from=build /tmp/front-end/build /usr/local/tomcat/webapps/ROOT

EXPOSE 8080

CMD ["catalina.sh","run"]