# Subscription Service Demo

A Spring Boot application demonstrating subscription management with synchronized operations and a jQuery-based frontend.

## Features

- REST endpoints for subscription management
- Synchronized subscription operations
- jQuery-based frontend with radio button selection
- Automatic plan switching with proper state management
- Development mode with hot reload support

## Prerequisites

- Java 17 or higher
- Maven 3.6 or higher
- Modern web browser (Chrome, Firefox, etc.)

## Getting Started

1. Run the application:
```bash
mvn spring-boot:run
```

2. Open your browser and navigate to:
```
http://localhost:8080
```

## Development

The project includes Spring Boot DevTools for enhanced development experience:
- Automatic application restart when Java files change
- Live reload of static resources (HTML, CSS, JS)
- Disabled caching for easier development

## API Endpoints

- `POST /api/subscription/subscribe/{months}` - Subscribe to a plan
- `POST /api/subscription/unsubscribe/{months}` - Unsubscribe from a plan

## License

This project is licensed under the MIT License - see the LICENSE file for details.