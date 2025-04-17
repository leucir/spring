# Spring Boot Application with PostgreSQL and RabbitMQ

This is a basic Spring Boot application that demonstrates:

1. RESTful API endpoints
2. PostgreSQL database integration
3. RabbitMQ messaging
4. Spring AOP for logging aspects

## Features

- User CRUD operations with RESTful API
- Database persistence with PostgreSQL
- Messaging with RabbitMQ
- AOP for method logging

## Prerequisites

- Java 17+
- Maven
- PostgreSQL (running locally on port 5432)
- RabbitMQ (running locally on port 5672)

## Database Setup

Run the local DB server

```bash
/opt/homebrew/opt/postgresql@14/bin/postgres -D /opt/homebrew/var/postgresql@14
```

Create a PostgreSQL database named `marin_db`:

```sql
CREATE DATABASE marin_db;
```

The application is configured to use:
- Username: postgres
- Password: postgres

You can modify these settings in `application.properties`.

## RabbitMQ Setup

Start the service
```bash
CONF_ENV_FILE="/opt/homebrew/etc/rabbitmq/rabbitmq-env.conf" /opt/homebrew/opt/rabbitmq/sbin/rabbitmq-server
# highly recommended: enable all feature flags on the running node
/opt/homebrew/sbin/rabbitmqctl enable_feature_flag all
```

Stop the service
```bash
# stops the locally running RabbitMQ node
brew services stop rabbitmq
```

The application expects RabbitMQ to be running locally with default settings:
- Host: localhost
- Port: 5672
- Username: guest
- Password: guest

## Running the Application

```bash
mvn spring-boot:run
```

The server will start on port 8080.

## API Endpoints

### User API

- List all users: `GET /api/users`
- Get a user: `GET /api/users/{id}`
- Create a user: `POST /api/users`
- Update a user: `PUT /api/users/{id}`
- Delete a user: `DELETE /api/users/{id}`

## Messaging

The application will produce messages to RabbitMQ when:
- A user is created
- A user is updated
- A user is deleted

These messages are consumed and logged.

## Logging

The application uses AOP to log:
- Method entry and exit
- Method parameters
- Method execution time
- Exceptions 