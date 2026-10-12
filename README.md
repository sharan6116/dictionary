# Dictionary Application

A containerized Java Spring Boot dictionary application that uses the free [Dictionary API](https://dictionaryapi.dev/).

## 🌟 Features

- 🔍 Search for word definitions in real-time
- 🔊 Listen to word pronunciations (audio)
- 📚 View meanings, examples, synonyms, and antonyms
- 🎨 Beautiful and responsive UI
- 🐳 Fully containerized with Docker
- ⚡ REST API interface
- 🔄 Reactive programming with Spring WebFlux

## 📋 Prerequisites

- **Docker & Docker Compose** (for containerized setup) - [Install Docker](https://www.docker.com/products/docker-desktop)
- **Java 17+** (for local development) - [Install Java](https://adoptopenjdk.net/)
- **Maven 3.9+** (for local development) - [Install Maven](https://maven.apache.org/)

## 🚀 Quick Start

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

3. Open your browser and visit:
```
http://localhost:8080
```

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

4. Open your browser and visit:
```
http://localhost:8080
```

## 📱 Using the Application

1. **Enter a word** in the search box
2. **Click Search** or press Enter
3. **View results** including:
   - Word pronunciation (phonetic)
   - Audio pronunciation (click the 🔊 button)
   - Definitions with examples
   - Synonyms and antonyms
   - Source references

## 🔌 API Endpoints

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

## 📁 Project Structure

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
│           ├── static/
│           │   └── index.html
│           └── application.yml
├── Dockerfile
├── docker-compose.yml
├── .dockerignore
├── .gitignore
├── pom.xml
└── README.md
```

## 🛠️ Tech Stack

- **Backend:**
  - Java 17
  - Spring Boot 3.1.5
  - Spring WebFlux (Reactive)
  - Maven

- **Frontend:**
  - HTML5
  - CSS3
  - Vanilla JavaScript

- **Deployment:**
  - Docker
  - Docker Compose

## 🐳 Docker Commands

### Build Docker image manually:
```bash
docker build -t dictionary-app:1.0.0 .
```

### Run the container:
```bash
docker run -p 8080:8080 dictionary-app:1.0.0
```

### View logs:
```bash
docker-compose logs -f dictionary-app
```

### Stop the container:
```bash
docker-compose down
```

## 📝 Environment Variables

You can override settings in `docker-compose.yml`:

- `JAVA_OPTS`: JVM options (default: -Xmx512m -Xms256m)
- `SPRING_APPLICATION_NAME`: Application name (default: dictionary-app)
- `SPRING_PROFILES_ACTIVE`: Spring profile (default: prod)

## 📖 API Documentation

This application uses the free Dictionary API provided by [dictionaryapi.dev](https://dictionaryapi.dev/)

**Free Dictionary API:**
- Base URL: `https://api.dictionaryapi.dev/api/v2/entries/en`
- No authentication required
- No rate limiting for reasonable use

## 🔊 Features in Detail

### Word Search
- Real-time search functionality
- Case-insensitive searching
- Instant results display

### Audio Pronunciation
- Click the speaker icon to hear pronunciation
- Audio provided by the Dictionary API

### Definition Display
- Full word definition
- Usage examples
- Part of speech classification

### Synonyms & Antonyms
- Related words
- Opposite words
- Color-coded display

## 🐛 Troubleshooting

### Port 8080 already in use
```bash
# Change the port in docker-compose.yml
ports:
  - "8081:8080"  # Access at http://localhost:8081
```

### Container fails to start
```bash
# Check logs
docker-compose logs dictionary-app

# Rebuild without cache
docker-compose up --build --no-cache
```

### API not responding
- Ensure Docker container is running: `docker-compose ps`
- Check internet connection for external API calls
- Verify Dictionary API is accessible: `curl https://api.dictionaryapi.dev/api/v2/entries/en/hello`

## 📄 License

This project is open source and available under the MIT License.

## 🤝 Contributing

Contributions are welcome! Feel free to submit a Pull Request or open an Issue.

## 📧 Support

For issues, questions, or suggestions, please open an issue on [GitHub](https://github.com/sharan6116/dictionary/issues).

---

**Made with ❤️ by Sharavanan**