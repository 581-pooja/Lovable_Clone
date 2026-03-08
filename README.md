# 🤖 Lovable Clone - AI-Powered Code Generation Platform

A full-stack application that generates complete web applications using AI. Built with Spring Boot and Spring AI, featuring multi-model LLM support, object storage, and Kubernetes-based deployment infrastructure.

## ✨ Features

### AI Code Generation
- 🤖 Multi-model LLM support via OpenRouter (Grok, DeepSeek, Gemini, and 100+ models)
- 💬 Chat-based interface for natural language code generation
- 🔄 Streaming responses for real-time generation feedback
- 📝 Context-aware code modifications using Spring AI function calling
- 🎨 Generate full-stack React + TypeScript applications with Tailwind CSS

### Project Management
- 📁 MinIO object storage for project files (S3-compatible)
- 📂 File tree structure with hierarchical organization
- 🔍 File content viewing and management
- 💾 Persistent storage for all generated code
- 🗂️ Project metadata tracking

### Authentication & Security
- 🔐 JWT-based authentication
- 👤 User registration and login
- 🔒 Spring Security 6.x integration
- 🛡️ Role-based access control

### Deployment & Execution
- 🐳 Kubernetes-based deployment infrastructure
- 🚀 Isolated code execution in runner pods
- 📊 Deployment status tracking
- 🔄 Container orchestration with Fabric8 Kubernetes client

### Payment & Subscriptions
- 💳 Stripe payment integration
- 📦 Multiple subscription plans
- 🔔 Webhook handling for payment events
- 💰 Customer portal for subscription management

## 🛠 Tech Stack

**Backend**
- Spring Boot 4.0.0
- Java 21
- Spring AI 2.0.0-M1
- Spring Security 6.x

**AI & LLM**
- Spring AI Framework
- OpenRouter API (Multi-model support)
- Function calling for tool integration

**Database & Storage**
- PostgreSQL 15+ (User data, projects, subscriptions)
- MinIO (S3-compatible object storage)
- Redis 7.x (Session management)

**Infrastructure**
- Docker for containerization
- Kubernetes for orchestration
- Fabric8 Kubernetes Client 7.3.1
- Custom Node.js shuttle proxy

**Payment**
- Stripe API v31.1.0

**Documentation**
- SpringDoc OpenAPI 3.0.2
- Swagger UI

**Additional Libraries**
- Lombok (Code generation)
- MapStruct 1.6.3 (DTO mapping)

## 🚀 Getting Started

### Prerequisites
- Java 21+
- PostgreSQL 15+
- Redis 7+
- MinIO
- Docker & Kubernetes
- Maven 3.8+

## 🔌 API Endpoints

### 🔐 Authentication

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| `POST` | `/api/auth/signup` | User registration | ❌ |
| `POST` | `/api/auth/login` | User login | ❌ |
| `GET` | `/api/auth/me` | Get current user | ✅ |

### 📁 Projects

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| `GET` | `/api/projects` | Get all user projects | ✅ |
| `GET` | `/api/projects/{id}` | Get project by ID | ✅ |
| `POST` | `/api/projects` | Create new project | ✅ |
| `PATCH` | `/api/projects/{id}` | Update project | ✅ |
| `DELETE` | `/api/projects/{id}` | Delete project | ✅ |
| `POST` | `/api/projects/{id}/deploy` | Deploy project | ✅ |

### 🤖 AI Chat

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| `POST` | `/api/chat/stream` | Stream AI responses (SSE) | ✅ |
| `GET` | `/api/chat/projects/{projectId}` | Get chat history | ✅ |

### 📂 Files

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| `GET` | `/api/projects/{projectId}/files` | Get file tree | ✅ |
| `GET` | `/api/projects/{projectId}/files/content?path=` | Get file content | ✅ |

### 💳 Billing & Subscriptions

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| `GET` | `/api/plans` | Get all subscription plans | ❌ |
| `GET` | `/api/me/subscription` | Get current subscription | ✅ |
| `POST` | `/api/payments/checkout` | Create checkout session | ✅ |
| `POST` | `/api/payments/portal` | Open customer portal | ✅ |

### 🔔 Webhooks

| Method | Endpoint | Description | Auth |
|--------|----------|-------------|------|
| `POST` | `/webhooks/payment` | Stripe webhook handler | ⚠️ Signature |

## 🚧 Future Scope
- 🚀 **CI/CD Pipeline**: GitHub Actions workflow for automated build, test, and deployment to Kubernetes
- 🖥️ **Live Preview System**: Real-time preview of generated applications with shareable URLs and embedded iframe
- 📬 **Kafka Integration**: Event-driven architecture for asynchronous code generation and deployment notifications
- 🧪 **Testing Suite**: Comprehensive unit, integration, and load tests with code coverage reports
- ⚡ **Performance Optimization**: Redis caching, query optimization, and API rate limiting

### This Project demonstrates:
- ✅ Advanced AI integration with Spring AI
- ✅ Cloud-native development (Docker, K8s, MinIO, Redis)
- ✅ RESTful API design with OpenAPI docs
- ✅ JWT authentication & authorization
- ✅ Payment integration with Stripe
- ✅ Object storage (S3-compatible)
- ✅ Modern Java 21 & Spring Boot 4.0
- ✅ Production-ready patterns (DTO, Service, Repository) 
