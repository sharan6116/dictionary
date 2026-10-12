# Dictionary Application

A containerized Java Spring Boot dictionary application that uses the free [Dictionary API](https://dictionaryapi.dev/).

## Features

- Search for word definitions
- Get phonetic pronunciations
- View meanings and parts of speech
- See examples, synonyms, and antonyms
- Fully containerized with Docker
- REST API interface
- Reactive programming with Spring WebFlux

## Prerequisites

- Docker & Docker Compose (for containerized setup)
- Java 17+ (for local development)
- Maven 3.9+ (for local development)

## Getting Started

### Using Docker Compose (Recommended)

1. Clone the repository:
```bash
git clone https://github.com/sharan6116/dictionary.git
cd dictionary
```

2. Build and run with Docker Compose:
```bash
docker-compose up --build
```

The application will be available at `http://localhost:8080`

### Local Development

1. Clone the repository:
```bash
git clone https://github.com/sharan6116/dictionary.git
cd dictionary
```

2. Build the project:
```bash
mvn clean package
```

3. Run the application:
```bash
mvn spring-boot:run
```

The application will be available at `http://localhost:8080`

## API Endpoints

### Search for a Word
```
GET /api/v1/dictionary/search/{word}
```

**Example:**
```bash
curl http://localhost:8080/api/v1/dictionary/search/hello
```

**Response:**
```json
[
  {
    "word": "hello",
    "phonetic": "/həˈloʊ/",
    "phonetics": [...],
    "meanings": [...],
    "license": {...},
    "sourceUrls": [...]
  }
]
```

### Health Check
```
GET /api/v1/dictionary/health
```

**Response:**
```
Dictionary API is running!
```

## Project Structure

```
dictionary/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/dictionary/
│       │       ├── DictionaryApplication.java
│       │       ├── client/
│       │       │   └── DictionaryAPIClient.java
│       │       ├── config/
│       │       │   └── WebClientConfig.java
│       │       ├── controller/
│       │       │   └── DictionaryController.java
│       │       ├── model/
│       │       │   ├── Definition.java
│       │       │   ├── License.java
│       │       │   ├── Meaning.java
│       │       │   ├── Phonetic.java
│       │       │   └── WordResult.java
│       │       └── service/
│       │           └── DictionaryService.java
│       └── resources/
│           └── application.yml
├── Dockerfile
├── docker-compose.yml
├── .dockerignore
├── .gitignore
├── pom.xml
└── README.md
```

## Technology Stack

- **Java 17**
- **Spring Boot 3.1.5**
- **Spring WebFlux** (Reactive)
- **Maven**
- **Docker & Docker Compose**
- **Lombok**
- **Jackson** (JSON processing)

## Environment Variables

You can override the following settings in `docker-compose.yml`:

- `SPRING_APPLICATION_NAME`: Application name (default: dictionary-app)
- `SPRING_PROFILES_ACTIVE`: Active Spring profile (default: prod)
- `JAVA_OPTS`: JVM options (default: -Xmx512m -Xms256m)

## Docker Build

### Build the Docker image manually:
```bash
docker build -t dictionary-app:1.0.0 .
```

### Run the container:
```bash
docker run -p 8080:8080 dictionary-app:1.0.0
```

## API Reference

### Dictionary API Documentation
This application uses the free Dictionary API provided by [dictionaryapi.dev](https://dictionaryapi.dev/)

## Logging

The application logs are configured in `application.yml`. By default:
- Root level: INFO
- Dictionary package level: DEBUG

View logs with Docker Compose:
```bash
docker-compose logs -f dictionary-app
```

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available under the MIT License.

## Support

For issues, questions, or suggestions, please open an issue on GitHub.
