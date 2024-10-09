# Etapa 1: Construção
FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app

# Copiar o arquivo pom.xml e outros arquivos de configuração
COPY pom.xml ./

# Baixar as dependências necessárias (cache)
RUN mvn dependency:go-offline -B

# Copiar os arquivos de código-fonte para o diretório de trabalho
COPY src ./src

# Compilar o projeto e gerar o arquivo JAR
RUN mvn clean package -DskipTests

# Etapa 2: Execução
FROM eclipse-temurin:21-jre
WORKDIR /app

# Copiar o JAR gerado na etapa de construção para o diretório de trabalho
COPY --from=build /app/target/*.jar app.jar

# Expor a porta em que a aplicação será executada
EXPOSE 8080

# Definir o comando de inicialização da aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]

