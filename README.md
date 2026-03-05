# Analytics Dashboard

A Spring Boot web application that displays real-time analytics charts, integrating data from a MySQL database and an external currency API (NBP). Deployed on Google Cloud Run.

🔗 **Live Demo:** [analyticsdashboard-432700912336.europe-central2.run.app/dashboard](https://analyticsdashboard-432700912336.europe-central2.run.app/dashboard)

---

##  Tech Stack

- **Backend:** Java 17, Spring Boot 3.2.5
- **Frontend:** Thymeleaf, Chart.js
- **Database:** MySQL (Spring Data JPA)
- **External API:** NBP (National Bank of Poland) — currency exchange rates
- **HTTP Client:** Apache HttpClient5 + Spring RestTemplate
- **Build Tool:** Maven
- **Deployment:** Google Cloud Run (europe-central2)

---

##  Project Structure

```
CloudChartsProj/
├── src/
│   ├── main/
│   │   ├── java/com/cloudcharts/
│   │   │   ├── CloudChartsProjApplication.java   # Entry point
│   │   │   ├── controller/
│   │   │   │   ├── CloudChartsController.java    # REST API endpoints
│   │   │   │   └── ViewController.java           # Thymeleaf view controller
│   │   │   ├── config/
│   │   │   │   └── RestTemplateConfig.java       # HTTP client configuration
│   │   │   ├── dto/
│   │   │   │   ├── NbpRateDto.java               # NBP rate data transfer object
│   │   │   │   └── NbpResponseDto.java           # NBP API response wrapper
│   │   │   ├── entity/
│   │   │   │   ├── AppsVisits.java               # Entity: app visit statistics
│   │   │   │   ├── Inventory.java                # Entity: inventory data
│   │   │   │   ├── Sales.java                    # Entity: sales data
│   │   │   │   └── Temperature.java              # Entity: temperature data
│   │   │   ├── repository/
│   │   │   │   ├── AppsVisitsRepository.java
│   │   │   │   ├── InventoryRepository.java
│   │   │   │   ├── SalesRepository.java
│   │   │   │   └── TemperatureRepository.java
│   │   │   └── service/
│   │   │       └── CurrencyService.java          # Fetches exchange rates from NBP API
│   │   └── resources/
│   │       ├── templates/
│   │       │   └── dashboard.html                # Main dashboard view
│   │       ├── static/
│   │       │   └── charts.js                     # Chart.js chart definitions
│   │       └── application.properties            # App configuration
│   └── test/
│       └── CloudchartsScenarioTests.java         # Integration / scenario tests
└── pom.xml
```

---

##  Configuration

Edit `src/main/resources/application.properties` to set your database connection and other parameters:

```properties
spring.datasource.url=jdbc:mysql://<HOST>:<PORT>/<DATABASE>
spring.datasource.username=<USERNAME>
spring.datasource.password=<PASSWORD>
spring.jpa.hibernate.ddl-auto=update
```

Sensitive values can be managed using a `.env` file via the `java-dotenv` library.

---

##  Database Tables

The application reads from four MySQL tables:

| Table         | Description                        |
|---------------|------------------------------------|
| `apps_visits` | Application visit statistics       |
| `inventory`   | Inventory levels over time         |
| `sales`       | Sales figures                      |
| `temperature` | Temperature sensor readings        |

---

##  Dependencies

| Dependency                         | Purpose                          |
|------------------------------------|----------------------------------|
| `spring-boot-starter-web`          | REST API & web layer             |
| `spring-boot-starter-thymeleaf`    | HTML templating engine           |
| `spring-boot-starter-data-jpa`     | Database access via JPA          |
| `mysql-connector-j`                | MySQL JDBC driver                |
| `httpclient5`                      | HTTP client for external API     |
| `java-dotenv`                      | Environment variable management  |
| `spring-boot-starter-test`         | Testing framework                |

---

##  Running Locally

### Prerequisites

- Java 17+
- Maven 3.8+
- MySQL database

### Steps

```bash
# Clone the repository
git clone <repo-url>
cd CloudChartsProj

# Configure application.properties with your DB credentials

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run
```

The app will be available at [http://localhost:8080/dashboard](http://localhost:8080/dashboard).

---

##  Testing

```bash
mvn test
```

Scenario-based integration tests are located in `CloudchartsScenarioTests.java`.

---

##  Deployment

The application is containerized and deployed to **Google Cloud Run** in the `europe-central2` region.

# Deploy to Cloud Run
gcloud run deploy analyticsdashboard \
  --image gcr.io/<PROJECT_ID>/cloudcharts-proj \
  --region europe-central2 \
  --platform managed


---

##  API Endpoints

| Method | Endpoint         | Description                          |
|--------|------------------|--------------------------------------|
| `GET`  | `/dashboard`     | Main dashboard HTML view             |
| `GET`  | `/api/...`       | REST endpoints for chart data (JSON) |

---

##  Author

**Artem Bredak*

  <img width="476" height="609" alt="Screenshot 2026-03-05 at 08 49 24" src="https://github.com/user-attachments/assets/e40641f6-d5ec-4239-b57f-6ef9f3078506" />

```
