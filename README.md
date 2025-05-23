
# 📽️ Spring Boot Video API com Supabase e Deploy na Koyeb

Este projeto é uma API REST desenvolvida com **Spring Boot** para **listar vídeos armazenados em um bucket público do Supabase**. A aplicação foi hospedada gratuitamente na **Koyeb**.

---

## ✅ Funcionalidades

- 📦 Conecta a um bucket do Supabase Storage.
- 📄 Lista vídeos públicos com nome e descrição.
- 🌐 Disponibiliza os vídeos através de uma API REST.
- 🚀 Deploy contínuo na **Koyeb**.

---

## 🛠️ Tecnologias utilizadas

- Java 21  
- Spring Boot 3  
- Spring Data JPA  
- PostgreSQL (Supabase)  
- Supabase Storage (público)  
- Koyeb (deploy gratuito)  
- Maven  
- Docker (opcional)

---

## 🗃️ Estrutura do Projeto

```bash
src/
├── main/
│   ├── java/com/seuprojeto/
│   │   ├── controller/
│   │   │   └── VideoController.java
│   │   ├── model/
│   │   │   └── Video.java
│   │   ├── repository/
│   │   │   └── VideoRepository.java
│   │   ├── service/
│   │   │   └── VideoService.java
│   │   └── Application.java
│   └── resources/
│       ├── application.yml
│       └── static/
└── README.md
```

---

## 🧠 Como funciona

A API conecta-se ao Supabase e retorna uma lista de vídeos com:
- URL pública  
- Nome  
- Descrição  

Esses vídeos são armazenados no bucket **público** `videos` do Supabase.

---

## ⚙️ Configuração do ambiente

Crie um arquivo `.env` com:

```env
DATABASE_URL=jdbc:postgresql://db.ozidmttuoymngufcnjsx.supabase.co:5432/postgres?sslmode=require
DATABASE_USER=postgres
DATABASE_PASSWORD=Luckymydog8080

SUPABASE_BUCKET_URL=https://ozidmttuoymngufcnjsx.supabase.co/storage/v1/object/public/videos/
SUPABASE_ANON_KEY=eyJhb...
```

---

## 🧾 application.yml

```yaml
spring:
  datasource:
    url: ${DATABASE_URL}
    username: ${DATABASE_USER}
    password: ${DATABASE_PASSWORD}
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect

supabase:
  bucket-url: ${SUPABASE_BUCKET_URL}
  api-url: https://ozidmttuoymngufcnjsx.supabase.co
  anon-key: ${SUPABASE_ANON_KEY}
```

---

## 🔁 Exemplo de resposta da API

```json
[
  {
    "name": "video1.mp4",
    "description": "Demonstração do Produto",
    "url": "https://ozidmttuoymngufcnjsx.supabase.co/storage/v1/object/public/videos/video1.mp4"
  },
  {
    "name": "trailer.mp4",
    "description": "Trailer institucional",
    "url": "https://ozidmttuoymngufcnjsx.supabase.co/storage/v1/object/public/videos/trailer.mp4"
  }
]
```

---

## ☁️ Deploy na Koyeb

1. Vá para: [https://app.koyeb.com](https://app.koyeb.com)  
2. Clique em **Create App**  
3. Escolha **GitHub Repository**  
4. Configure:  
   - **Build command:** `./mvnw package`  
   - **Run command:** `java -jar target/seu-jar-final.jar`  
5. Adicione as variáveis de ambiente da `.env`  
6. Deploy automático a cada push!

---

## 📌 Requisitos

- Conta no [Supabase](https://supabase.com)  
- Conta na [Koyeb](https://www.koyeb.com/)  
- Java 21 instalado  
- Git

---

## 💡 Possibilidades de expansão

- Upload de vídeos autenticado  
- Player de vídeo no front-end  
- Filtros por categoria/tags  
- Painel de administração

---

## 🤝 Contribuições

Pull Requests são bem-vindos!  
Sinta-se livre para abrir issues ou sugerir melhorias.

---

## ⚠️ Aviso de segurança

**Nunca exponha a `service_role` key do Supabase.**  
Este projeto usa apenas a `anon` key para acesso ao bucket **público**.
