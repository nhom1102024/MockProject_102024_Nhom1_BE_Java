# Lease Master
*Lease Master* is an application designed for managing apartment complexes. This project is simple yet incredibly useful.
 
## Technologies 
- Spring Boot (v3.3.4)
- Spring Data JPA
- Spring Validation
- Spring Security + JWT Token
- SQL Server
- Mapstruct
- Lombok
- Swagger (Open API)

## Run the Application

1. **Setting up the environtment:**

- You need to make sure that the database is up.
- If you're using Docker, you can use ```docker compose up -d``` command. (If you have made changes in local, you should use the *local-docker-compose* file.)

2. **Create an `.env` file:**

- Copy the contents of `.env.example` file and paste it into a new file named `.env`.
- Fill in the required values in the `.env`

3. **Run the project:**

- Navigate to the root of the project. For building the project using command line, run below command :
 
``` mvn clean install```

- Run service in command line. Navigate to *target* directory. 

``` java -jar lease-master.jar ```

## Postman Collection

- [You can access the Postman collection here and you can try it after you get the project up and running.](https://www.postman.com/martian-flare-44482/workspace/mocproject-102024-group1/collection/27401620-0a5c801f-bf68-4663-a342-b529521f0fbb?action=share&creator=39001489)

### Others
 
### License

Apache License 2.0
