
#  Back End do Aplicativo Alfabetização Digital (Projeto de Extensão)

Back End desenvolvido com **Spring Boot** para **listar vídeos armazenados em um bucket público do Supabase**. A aplicação foi hospedada gratuitamente na **Koyeb**.

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
- PostgreSQL  
- Supabase Storage 
- Koyeb 
- Maven  
- Docker 

---

## Fluxo

A API conecta-se ao Supabase e retorna uma lista de vídeos com:
- URL pública  
- Nome  
- Descrição  

Esses vídeos são armazenados no bucket **público** `videos` do Supabase.

---


##  body josn de resposta quando for fazer uma consulta para retornar os videos

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
##  Requisição body json para importar os videos ou para editar 

```json
  {
    "title": "",
    "description": "",
    "filename": ""
  }
```


<img src="https://github.com/MOliveiraDev/Alfa_Digital/blob/main/Doc/Back-End%20do%20Aplicativo%20Alfabetiza%C3%A7%C3%A3o%20Digital%20(Projeto%20de%20Extens%C3%A3o_pages-to-jpg-0001.jpg"></img>

<img src="https://github.com/MOliveiraDev/Alfa_Digital/blob/main/Doc/Back-End%20do%20Aplicativo%20Alfabetiza%C3%A7%C3%A3o%20Digital%20(Projeto%20de%20Extens%C3%A3o_pages-to-jpg-0002.jpg"></img>

<img src="https://github.com/MOliveiraDev/Alfa_Digital/blob/main/Doc/Back-End%20do%20Aplicativo%20Alfabetiza%C3%A7%C3%A3o%20Digital%20(Projeto%20de%20Extens%C3%A3o_pages-to-jpg-0003.jpg"></img>
