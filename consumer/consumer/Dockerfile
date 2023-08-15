FROM node:14-alpine

WORKDIR /app

COPY package.json package-lock.json ./

RUN npm install

COPY . .

RUN npm run build

EXPOSE 4200

CMD ["npm", "start"]

#docker build -t frontend:site1 .
#docker run -d -p 4200:4200 frontend:site1
#docker stop $(docker ps -a -q)
