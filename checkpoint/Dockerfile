# Definindo a imagem base que vamos utilizar
FROM node:14-alpine

# Copia todos os arquivos da pasta atual para dentro do container
COPY . /checkpoint

# Define o diretório de trabalho dentro do container
WORKDIR /checkpoint/app

# Instala as dependências
RUN npm install

# Builda a aplicação
RUN npm run build

# Define qual comando será executado quando o contêiner for iniciado
CMD [ "npm", "start" ]
