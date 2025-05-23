
#  Back End do Aplicativo Alfabetização Digital (Projeto de Extensão)

Bakc End desenvolvido com **Spring Boot** para **listar vídeos armazenados em um bucket público do Supabase**. A aplicação foi hospedada gratuitamente na **Koyeb**.

---

## Funcionalidades

-  Importar os videos para o Supabase Storage.
-  Editar titulo, descrição e videos importados.
-  Lista vídeos públicos com nome e descrição.
-  Disponibiliza os vídeos através de uma API REST.

---

## Tecnologias utilizadas

- Java 21  
- Spring Boot 3  
- Spring Data JPA  
- PostgreSQL (Supabase)  
- Supabase Storage (público)  
- Koyeb (deploy gratuito)  
- Maven  
- Docker (opcional)

---

## Fluxo

A API conecta-se ao Supabase e retorna uma lista de vídeos com:
- URL pública  
- Nome  
- Descrição  

Esses vídeos são armazenados no bucket **público** `videos` do Supabase.

---


##  Requisição Get para retornar os videos

```json
[
  {
    "name": "video1.mp4",
    "description": "Demonstração do Produto",
    "url": "<DATABASE_URL>/video1.mp4"
  },
  {
    "name": "trailer.mp4",
    "description": "Trailer institucional",
    "url": "<DATABASE_URL>/trailer.mp4"
  }
]
```
##  Requisição Get para retornar os videos ou para editar 

```json
  {
    "title": "",
    "description": "",
    "filename": ""
  }
```
