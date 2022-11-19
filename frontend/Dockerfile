FROM node:13.12.0-alpine
WORKDIR /app
COPY package.json /frontend/
COPY package-lock.json /frontend/
RUN npm install
COPY . .
RUN npm run build
ENTRYPOINT ["npm", "start"]