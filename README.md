# Convertendo arquivos JSON/ODTs para PDF com Java-Quarkus

Bem-vindo ao projeto!
Este projeto foi desenvolvido para converter dados JSON em arquivos ODT e, em seguida, em PDF, utilizando Quarkus, FreeMarker e XDocReport. É uma aplicação prática que combina os conceitos de seguros com tecnologias modernas de desenvolvimento.

## Stack utilizada

- **Back-end:** Quarkus, Framework Java para desenvolvimento de microsserviços eficientes e escaláveis.
- **Bibliotecas**:
    - **FreeMarker**: Ferramenta de template engine para Java.
    - **XDocReport**: Biblioteca para gerar documentos no formato OpenDocument (ODT) e Microsoft Office (DOCX, PPTX).

## Funcionalidades

- Conversão de dados JSON para arquivos ODT.
- Conversão de arquivos ODT para PDF.
- Configuração dinâmica de templates baseados em diferentes tipos de documentos de seguro.

## Como executar
- Pré-requisitos:
    - JDK 11+.
    - Maven 3.6.3+.
    - Docker.
  ### Exemplos de JSONs para testar:
    - template_1(Seguro Automóvel)
  ```json
  {
	"policyNumber": "123456789",
	"produto": "Seguro Automóvel",
	"processoSusep": "987654",
	"codigoRamo": "001",
	"proposta": "789456",
	"apoliceRenovar": "456789",
	"endosso": "654321",
	"dataEmissao": "2024-06-06",
	"vigenciaSeguro": "2024-06/2025-06",
	"seguradora": {
		"cnpj": "12345678000199",
		"codigoSusep": "123456",
		"endereco": "Rua Seguradora, 123",
		"celular": "(11) 98765-4321"
	},
	"segurado": {
		"nome": "João Silva",
		"cpfCnpj": "12345678901",
		"dataNascimento": "1980-01-01",
		"sexo": "Masculino",
		"profAtiv": "Engenheiro",
		"salario": "5000",
		"endereco": "Rua Segurado, 456",
		"numero": "456",
		"comp": "Apto 101",
		"bairro": "Bairro Seguro",
		"cep": "12345-678",
		"cidade": "São Paulo",
		"estado": "SP",
		"telefone": "(11) 1234-5678",
		"celular": "(11) 98765-4321",
		"email": "joao.silva@example.com"
	},
	"veiculo": {
		"nome": "Carro Modelo X",
		"marca": "Marca Y",
		"anoModelo": "2022",
		"km": "0",
		"dataSaida": "2024-06-01",
		"combustivel": "Gasolina",
		"categoria": "Passeio",
		"chassi": "9BWZZZ377VT004251",
		"placa": "ABC-1234",
		"proprietario": "João Silva"
	},
	"pagamento": {
		"premio": "2000",
		"custo": "50",
		"juros": "20",
		"iof": "25",
		"premioTotal": "2095",
		"formaPagamento": "Cartão de Crédito",
		"parcelas": "12"
	},
	"corretor": {
		"nome": "Corretor de Seguros",
		"susep": "789456",
		"telefone": "(11) 1234-5678",
		"email": "corretorexample.com"
	},
	"coberturaContratadas": "Cobertura Completa",
	"premio": "2000",
	"capitalSegurado": "50000",
	"cobertura": "Colisão",
	"franquia": "500",
	"tipoFranquia": "Reduzida",
	"assistenciaContratada": "Assistência 24h",
	"telefoneAcionamento": "(11) 987654321"
  }
  ```
- template_2(Segura Vida)
  ```json
  {
	"policyNumber": "123456789",
	"produto": "Seguro Automóvel",
	"processoSusep": "987654",
	"codigoRamo": "001",
	"proposta": "789456",
	"apoliceRenovar": "456789",
	"endosso": "654321",
	"dataEmissao": "2024-06-06",
	"vigenciaSeguro": "2024-06/2025-06",
	"seguradora": {
		"cnpj": "12345678000199",
		"codigoSusep": "123456",
		"endereco": "Rua Seguradora, 123",
		"celular": "(11) 98765-4321"
	},
	"segurado": {
		"nome": "João Silva",
		"cpfCnpj": "12345678901",
		"dataNascimento": "1980-01-01",
		"sexo": "Masculino",
		"profAtiv": "Engenheiro",
		"salario": "5000",
		"endereco": "Rua Segurado, 456",
		"numero": "456",
		"comp": "Apto 101",
		"bairro": "Bairro Seguro",
		"cep": "12345-678",
		"cidade": "São Paulo",
		"estado": "SP",
		"telefone": "(11) 1234-5678",
		"celular": "(11) 98765-4321",
		"email": "joao.silva@example.com"
	},
	"seguroVida": {
		"nome": "Maria Souza",
		"idade": "49",
		"valor": "100000",
		"cobertura": "Cobertura Completa",
		"beneficiarios": "João Souza"
	},
	"pagamento": {
		"premio": "2000",
		"custo": "50",
		"juros": "20",
		"iof": "25",
		"premioTotal": "2095",
		"formaPagamento": "Cartão de Crédito",
		"parcelas": "12"
	},
	"corretor": {
		"nome": "Corretor de Seguros",
		"susep": "789456",
		"telefone": "(11) 1234-5678",
		"email": "corretorexample.com"
	},
	"coberturaContratadas": "Cobertura Completa",
	"premio": "2000",
	"capitalSegurado": "50000",
	"cobertura": "Colisão",
	"franquia": "500",
	"tipoFranquia": "Reduzida",
	"assistenciaContratada": "Assistência 24h",
	"telefoneAcionamento": "(11) 987654321"
  }
  ```

## Contribuindo

Contribuições são sempre bem-vindas!
Sinta-se à vontade para modificar conforme necessário para se adequar ao seu projeto e estilo pessoal.
