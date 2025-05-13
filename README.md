
# 📦 QR Code Generator

Uma aplicação **Full Stack** desenvolvida em Java com Spring Boot + HTML/CSS/JavaScript, capaz de gerar QR Codes a partir de um texto e disponibilizar o resultado para visualização e download direto no navegador.

A imagem gerada é armazenada automaticamente em um bucket **AWS S3**, e sua URL pública é retornada pela API.

---

## 🚀 Funcionalidades

- ✅ Front-end elegante com interface web (input + visualização + botão de download)
- ✅ Geração de QR Code a partir de um texto via frontend ou API
- ✅ Upload automático da imagem para o Amazon S3
- ✅ URL pública gerada automaticamente
- ✅ Download do QR Code gerado em formato PNG

---

## 🌐 Acesse a Interface Web

A interface web está rodando em uma instância AWS EC2, podendo ser acessada na URL abaixo:

[http://ec2-34-200-237-15.compute-1.amazonaws.com/index.html](http://ec2-34-200-237-15.compute-1.amazonaws.com/index.html)

---

## 🧪 API – Detalhes Técnicos

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
  "url": "https://aws-qrcodes-storage.s3.us-east-1.amazonaws.com/uuid-gerado.png"
}
```

---

## 🛠️ Tecnologias Utilizadas

- Java 17
- Spring Boot
- HTML, CSS e Javascript
- AWS SDK (S3)
- Docker
- Maven

---

## ☁️ API em Produção

Caso queira fazer uma requisição diretamente para a API, você pode utilizar ferramentas como Postman, Insomnia ou cURL.

```bash
curl -X POST http://ec2-34-200-237-15.compute-1.amazonaws.com/qrcodegenerator \
-H "Content-Type: application/json" \
-d '{"text":"https://teste.com"}'
```

---

## ▶️ Como rodar o projeto localmente

```bash
# Clonar o projeto
git clone https://github.com/thiaguerassss/qrcode-generator.git
cd qrcode-generator
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

#### 💻 Sem Docker

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
