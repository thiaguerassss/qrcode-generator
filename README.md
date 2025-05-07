
# 📦 QR Code Generator API

Uma API REST desenvolvida em Java com Spring Boot que gera QR Codes a partir de um texto enviado via JSON e faz o upload da imagem gerada diretamente para um bucket AWS S3. A URL pública da imagem é retornada como resposta.

---

## 🚀 Funcionalidades

- ✅ Recebe um `text` via requisição HTTP POST
- ✅ Gera uma imagem QR Code (formato PNG)
- ✅ Realiza upload da imagem para um bucket AWS S3
- ✅ Retorna a URL pública da imagem hospedada na AWS

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- AWS SDK (S3)
- ZXing (`com.google.zxing`) para geração do QR Code
- Docker
- Maven

---

## 🧪 Requisição de Exemplo

### Endpoint

```
POST /qrcodegenerator
```

### Corpo da Requisição (`application/json`)
```json
{
  "text": "https://meusite.com"
}
```

### Resposta (`200 OK`)
```json
{
  "url": "https://meu-bucket.s3.sa-east-1.amazonaws.com/uuid-gerado.png"
}
```

---

## ▶️ Como rodar localmente

```bash
# Clonar o projeto
git clone https://github.com/thiaguerassss/qrcode-generator-api.git
cd qrcode-generator-api
```

### ⚙️ Configuração de Ambiente

#### 🐳 Usando Docker

1. Crie um arquivo `.env` na raiz do projeto com o seguinte conteúdo:

```env
AWS_ACCESS_KEY_ID=SUACHAVE
AWS_SECRET_ACCESS_KEY=SUASECRET
AWS_REGION=regiao-do-seu-bucket
AWS_BUCKET_NAME=nome-do-seu-bucket
```

2. Construa a imagem Docker:
```bash
docker build -t qrcode-app .
```

3. Execute o container com as variáveis do `.env`:
```bash
docker run --env-file .env -p 8080:8080 qrcode-app
```

---

#### 💻 Sem Docker (executando localmente)

Se preferir rodar sem Docker, você deve definir as variáveis de ambiente diretamente no seu sistema operacional:

#### Linux/macOS:
```bash
export AWS_ACCESS_KEY_ID=SUACHAVE
export AWS_SECRET_ACCESS_KEY=SUASECRET
export AWS_REGION=sa-east-1
export AWS_BUCKET_NAME=nome-do-seu-bucket
```

#### Windows (PowerShell):
```powershell
$env:AWS_ACCESS_KEY_ID="SUACHAVE"
$env:AWS_SECRET_ACCESS_KEY="SUASECRET"
$env:AWS_REGION="sa-east-1"
$env:AWS_BUCKET_NAME="nome-do-seu-bucket"
```

Em seguida, rode a aplicação:

```bash
./mvnw spring-boot:run
```

---

## ✅ Testes

Use ferramentas como **Postman**, **Insomnia** ou **cURL** para testar:

```bash
curl -X POST http://localhost:8080/qrcodegenerator \
-H "Content-Type: application/json" \
-d '{"text":"https://teste.com"}'
```

---

## 🛡️ Boas Práticas

- Nunca exponha suas chaves de acesso no Git.
- Certifique-se de adicionar o `.env` ao `.gitignore`.

---

## 📄 Licença

Este projeto está sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

## ✉️ Contato

Para dúvidas, sugestões ou contribuições:  
**[thiagobuenogoncalves@gmail.com]**
