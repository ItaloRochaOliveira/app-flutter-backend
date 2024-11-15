# flutter-backend-e-docker

# 📖 Apresentação

O projeto "flutter-backend-e-docker" é um CRUD simples para fazer teste da orm typeORM em node para utilização do banco de dados de mysql em Docker.

Também foi feito o uso da imagem/conteiner de MySQL no uso da API que posteriormente foi feito a construção da imagem dessa API para o uso posterior dela junto com o banco de dados em container.


### Informações Pessoais

- Italo Rocha Oliveira
- [Linkedin](https://www.linkedin.com/in/italorochaoliveira/).
- [Github](https://github.com/ItaloRochaOliveira).
- Email: italo.rocha.de.oliveira@gmail.com

## 📄 Concepção do Projeto

### Instalando

```bash
# Instalando o repositório localmente
git clone https://github.com/ItaloRochaOliveira/app-flutter-backend.git

# Entre no diretório do projeto
cd app-flutter-backend

##Cria a imagem da api atual do projeto
docker build -t flutter-backend-e-docker-api:1.0 ./

# Suba o container do banco de dados e da api
docker compose up -d

# executando o projeto no site
http://127.0.0.1:3003/users/getAll

```

#### OU

```bash
# Instalando o repositório localmente
git clone https://github.com/ItaloRochaOliveira/flutter-backend-e-docker.git

# Entre no diretório do projeto
cd APP-FLUTTER-BACKEND

###################################Criando o db no docker###############################################
##Cria Rede
docker network create minha-rede

##Cria DB
docker run --name FLUTTER-BACKEND-E-DOCKER-SQL \
  -e MYSQL_ROOT_PASSWORD=SenhaDocker123 \
  -e MYSQL_DATABASE=FLUTTER-BACKEND-E-DOCKER-SQL \
  -e MYSQL_USER=Italo \
  -e MYSQL_PASSWORD=SenhaSQL123 \
  --network minha-rede \
  -p 3306:3306 \
  -d mysql:5.7

##Importa tabelas do sql
docker cp tabelas.sql flutter-backend-E-DOCKER-SQL:/tabelas.sql

##Executar documento
docker exec -i flutter-backend-E-DOCKER-SQL mysql -u Italo -p SenhaSQL123 flutter-backend-E-DOCKER-SQL < ./tabelas.sql

###################################Criando a api no docker###############################################
##Cria a imagem da api
docker build -t flutter-backend-e-docker-api:1.0 ./

##Cria o contêiner da api
docker run -d --name api --network minha-rede -p 3003:3003 flutter-backend-e-docker-api:1.0

###################################Executando o projeto#################################################
# executando o projeto no site
http://127.0.0.1:3003/users/getAll

```

## 🔧 Funcionalidades

```bash
. Requisições:

-/users/getAll: Puxa todos os usuários do db.

-/users/create: Cria um usuário no db.

-/users/edit: Edita um usuário passando o id dele.

-/users/delete: Elimina um usuário passando o id dele.
```


## 📚 Bibliotecas utilizadas 

```bash
org.springframework.boot
org.springframework.boot
org.springframework.boot
org.springframework
org.springframework.boot
mysql
org.springframework.boot
com.h2database
org.springframework.boot

```
## 💻 Programas e tecnologias utilizadas


![VSCode](https://img.shields.io/badge/VSCODE-white?style=for-the-badge&logo=visualstudiocode&logoColor=blue)
![Insomnia](https://img.shields.io/badge/insomnia-white?style=for-the-badge&logo=insomnia&logoColor=purple)

![Java](https://img.shields.io/badge/Java-1572B6?style=for-the-badge&logo=java&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-orange?style=for-the-badge&logo=mysql&logoColor=blue)
![jest](https://img.shields.io/badge/jest-f8f8ff?style=for-the-badge&logo=jest&logoColor=black)
![Git](https://img.shields.io/badge/GIT-E44C30?style=for-the-badge&logo=git&logoColor=white)