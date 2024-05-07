# SolarWatch

Solarwatch is a learning project aimed at practising Spring Boot, JPA and React.<br>
The website allows users to retrieve the sunrise and sunset times based on a given city and date. It uses two external APIs: one to retrieve the coordinates of the city and another to retrieve the sunrise and sunset times. Once a query is made for specific data, it is stored in the database and subsequent searches retrieve it from there, improving efficiency.

## Technologies
* <a href="https://vitejs.dev/" target="blank"><img src="https://github.com/get-icon/geticon/blob/master/icons/vite.svg" height="25" /> Vite </a>
* <a href="https://react.dev/" target="blank"><img src="https://github.com/get-icon/geticon/blob/master/icons/react.svg" height="25" /> React </a>
* <a href="https://www.javascript.com/" target="blank"><img src="https://github.com/get-icon/geticon/blob/master/icons/javascript.svg" height="25" /> JavaScript </a>
* <a href="https://www.java.com/en/" target="blank"><img src="https://github.com/get-icon/geticon/blob/master/icons/java.svg" height="25" /> Java </a>
* <a href="https://spring.io/projects/spring-boot" target="blank"><img src="https://github.com/get-icon/geticon/blob/master/icons/spring.svg" height="25" /> Spring Boot </a>
* <a href="https://www.postgresql.org/" target="blank"><img src="https://github.com/get-icon/geticon/blob/master/icons/postgresql.svg" height="25" /> PostgreSQL </a>

## Prerequisites
Before running the project you need to set up the follow environment variables:

- `DB_URL`: URL for accessing the Supabase hosted SQL database.
- `DB_USERNAME`: Username for accessing the database.
- `DB_PASSWORD`: Password for accessing the database.
- `API_KEY`: You need an API key from <a href="https://openweathermap.org/api/geocoding-api" target=blank>Geocoding API</a>.

Also make sure you have the following applications installed:
  
- **Java Development Kit (JDK):** You can download it from the [official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) and follow the installation instructions.

- **Maven:** You can download it from the [official website](https://maven.apache.org/download.cgi) and follow the installation instructions.

- **Node.js and npm:** You can download and install Node.js from the [official website](https://nodejs.org/en/download/) or use a package manager for your operating system.

## Setup

- Clone the repository <br>
```
git clone <repository-url>
```
- Set up your environment variables

- Start the backend
```
mvn spring-boot: run
```
- Navigate to the frontend/solarwatch folder and install packages
```
npm install
```
- Start the frontend
```
npm run dev
```

The application should be available at [http://localhost:5173](http://localhost:5173) in your web browser.
