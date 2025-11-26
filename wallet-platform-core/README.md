# Wallet Platform Core

A core wallet platform service based on Spring Boot 3.2.0.

## Technology Stack

- **Spring Boot 3.2.0**
- **Java 17**
- **Maven Multi-module Project**
- **MyBatis Plus 3.5.8**
- **MySQL**
- **Redis & Redisson**
- **Kafka**
- **Spring Security**
- **OpenFeign**

## Project Structure

```
wallet-platform-service/
├── wallet-platform-core/        # Core service module (Spring Boot application)
├── wallet-project-mydoge/       # MyDoge wallet project
└── wallet-project-wlfi/         # WLFI wallet project
```

## Quick Start

### Prerequisites

- JDK 17+
- Maven 3.6+
- MySQL database
- Redis
- Kafka (optional)

### Configuration

Edit `src/main/resources/application-dev.yml` file to configure database and Redis connection:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/wallet_platform
    username: your_username
    password: your_password
  
  data:
    redis:
      host: localhost
      port: 6379
```

### Build Project

```bash
# Execute in project root directory
mvn clean package
```

### Run Application

```bash
# Method 1: Use Maven
cd wallet-platform-core
mvn spring-boot:run

# Method 2: Run JAR package
java -jar target/wallet-platform-core.jar

# Method 3: Run main class in IDE
# Run com.tomo.core.WalletPlatformCoreApplication
```

### Access Application

- **Application URL**: http://localhost:8081
- **API Documentation**: http://localhost:8081/doc.html (Knife4j)
- **Actuator Health Check**: http://localhost:8081/actuator/health
- **Prometheus Metrics**: http://localhost:8081/actuator/prometheus

## Main Features

- ✅ RESTful API service
- ✅ Database connection pool management
- ✅ Redis cache
- ✅ Distributed lock (Redisson)
- ✅ Scheduled tasks (XXL-Job)
- ✅ API documentation (Knife4j)
- ✅ Monitoring metrics (Prometheus)
- ✅ Security authentication (Spring Security + JWT)

## Development Guide

### Package Structure

```
com.tomo.core/
├── common/              # Common configurations and utilities
│   ├── config/         # Configuration classes
│   ├── constants/      # Constants
│   └── enums/          # Enums
├── controller/         # Controllers
├── mapper/             # MyBatis Mapper
├── pojo/               # Data objects
│   ├── do/            # Database objects
│   ├── dto/           # Data transfer objects
│   └── vo/            # View objects
├── service/            # Service layer
│   └── impl/          # Service implementation
└── util/               # Utility classes
```

### Annotation Description

- `@SpringBootApplication`: Spring Boot application main class
- `@MapperScan`: MyBatis Mapper scanning
- `@EnableFeignClients`: Enable Feign client
- `@EnableRetry`: Enable retry mechanism
- `@EnableScheduling`: Enable scheduled tasks

## Environment Configuration

The project supports multi-environment configuration:

- `application.yml` - Main configuration file
- `application-dev.yml` - Development environment
- `application-test.yml` - Test environment (needs to be created)
- `application-prod.yml` - Production environment (needs to be created)

Switch environment through `spring.profiles.active` or Maven profile.

## Important Notes

1. Ensure MySQL and Redis services are running normally
2. Need to configure internal dependency repository to obtain `com.tomo:common-util`
3. Please modify configuration in `application.yml` for production environment
4. Recommend using `application-{profile}.yml` to manage different environment configurations

## Common Issues

### 1. Dependency download failure

Ensure correct Maven repository is configured, especially `com.tomo:common-util` requires access to internal repository.

### 2. Database connection failure

Check if MySQL service is started and if connection configuration in `application-dev.yml` is correct.

### 3. Port conflict

If port 8081 is occupied, you can modify `server.port` in configuration file.

## Contact

For questions, please contact the development team.
