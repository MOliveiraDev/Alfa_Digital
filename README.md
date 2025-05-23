
#  Back End do Aplicativo Alfabetização Digital (Projeto de Extensão)

Bakc End desenvolvido com **Spring Boot** para **listar vídeos armazenados em um bucket público do Supabase**. A aplicação foi hospedada gratuitamente na **Koyeb**.

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

## 🧠 Como funciona

A API conecta-se ao Supabase e retorna uma lista de vídeos com:
- URL pública  
- Nome  
- Descrição  

Esses vídeos são armazenados no bucket **público** `videos` do Supabase.

---


## 🔁 Requisição Get 

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
