# ☁️ AQI Monitoring Backend

A **Spring Boot** REST API service that acts as a backend proxy for fetching Air Quality Index (AQI) data. It integrates with external AQI APIs, provides caching mechanisms for performance, and handles CORS for the frontend application.

## 🚀 Features

- **RESTful API:** Exposes endpoints to fetch air quality data by city name or geolocation.
- **Performance Caching:** Implements **Caffeine Cache** to store API responses for 5 minutes to reduce external API calls and latency.
- **CORS Support:** Configured to allow requests specifically from the frontend hosted at `http://localhost:5173`.
- **External Integration:** Uses `RestTemplate` to communicate with third-party AQI providers.

## 🛠️ Tech Stack

- **Java**: Core language.
- **Spring Boot**: Application framework.
- **Spring Cache (Caffeine)**: In-memory caching.
- **Spring Web**: REST controller and web services.
- **Maven**: Dependency management (implied).

## ⚙️ Configuration

To run this application, you must configure the **API Key** and **Endpoints** in your `src/main/resources/application.properties` file. The application relies on these specific property keys:

```properties
# Your External AQI Provider API Key (e.g., from AQICN.org)
api.key=YOUR_API_KEY_HERE

# API Endpoint Templates
# Note: Keep the placeholders CITY_NAME, YOUR_TOKEN, LATITUDE, and LONGITUDE as shown.
api.endpoint.city=[https://api.waqi.info/feed/CITY_NAME/?token=YOUR_TOKEN](https://api.waqi.info/feed/CITY_NAME/?token=YOUR_TOKEN)
api.endpoint.geo=[https://api.waqi.info/feed/geo:LATITUDE;LONGITUDE/?token=YOUR_TOKEN](https://api.waqi.info/feed/geo:LATITUDE;LONGITUDE/?token=YOUR_TOKEN)

# Server Port (Optional, defaults to 8080)
server.port=9091
```

🔌 API Endpoints
The base URL for all endpoints is /api/v1.

1. Get AQI by City
Fetches the current Air Quality Index for a specific city.

Endpoint: GET /aqi/{city}

Example: GET /aqi/London

Response: JSON object containing AQI value and city details

2. Get AQI by Geolocation
Fetches AQI data based on latitude and longitude coordinates.

Endpoint: GET /aqi/geo/{latitude}/{longitude}

Example: GET /aqi/geo/18.5204/73.8567

Response: JSON object containing AQI value and location details.
