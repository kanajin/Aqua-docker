# Aqua Server
Multipurpose game server powered by Spring Boot, for ALL.Net based games

This is a forked maintaining attempt of the [domeori-aqua](https://dev.s-ul.net/domeori/aqua)

Using docker to get simplified stat up

# Usage

- Download `datasource.zip` in the latest release and unzip
- edit file `config/application.properties:15`, change `allnet.server.host` to  the ipv4 address of your docker machine
- be sure port 80, 8443, 22345 is opened
- `datasource$ sudo docker-compose up`

# Data file
- Directory `config/` and `data/` contains your own configuration and userdata, you can get help in [domeori's project](https://dev.s-ul.net/domeori/aqua)

# Notice
- Because of using docker, `allnet.server.host` in `config/application.properties:15` should be set as your server host
