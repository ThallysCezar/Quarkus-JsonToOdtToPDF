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
	"seguradoraCnpj": "12345678000199",
	"seguradoraCodigoSusep": "123456",
	"seguradoraEndereco": "Rua Seguradora, 123",
	"seguradoraCelular": "(11) 98765-4321",
	"seguradoNome": "João Silva",
	"seguradoCpfCnpj": "12345678901",
	"seguradoDataNascimento": "1980-01-01",
	"seguradoSexo": "Masculino",
	"seguradoProfAtiv": "Engenheiro",
	"seguradoSalario": "5000",
	"seguradoEndereco": "Rua Segurado, 456",
	"seguradoNumero": "456",
	"seguradoComp": "Apto 101",
	"seguradoBairro": "Bairro Seguro",
	"seguradoCep": "12345-678",
	"seguradoCidade": "São Paulo",
	"seguradoEstado": "SP",
	"seguradoTelefone": "(11) 1234-5678",
	"seguradoCelular": "(11) 98765-4321",
	"seguradoEmail": "joao.silva@example.com",
	"veiculoNome": "Carro Modelo X",
	"veiculoMarca": "Marca Y",
	"veiculoAnoModelo": "2022",
	"veiculoKm": "0",
	"veiculoDataSaida": "2024-06-01",
	"veiculoCombustivel": "Gasolina",
	"veiculoCategoria": "Passeio",
	"veiculoChassi": "9BWZZZ377VT004251",
	"veiculoPlaca": "ABC-1234",
	"veiculoProprietario": "João Silva",
	"pagamentoPremio": "2000",
	"pagamentoCusto": "50",
	"pagamentoJuros": "20",
	"pagamentoIof": "25",
	"pagamentoPremioTotal": "2095",
	"pagamentoFormaPagamento": "Cartão de Crédito",
	"pagamentoParcelas": "12",
	"corretorNome": "Corretor de Seguros",
	"corretorSusep": "789456",
	"corretorTelefone": "(11) 1234-5678",
	"corretorEmail": "corretorexample.com",
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
	"seguradoraCnpj": "12345678000199",
	"seguradoraCodigoSusep": "123456",
	"seguradoraEndereco": "Rua Seguradora, 123",
	"seguradoraCelular": "(11) 98765-4321",
	"seguradoNome": "João Silva",
	"seguradoCpfCnpj": "12345678901",
	"seguradoDataNascimento": "1980-01-01",
	"seguradoSexo": "Masculino",
	"seguradoProfAtiv": "Engenheiro",
	"seguradoSalario": "5000",
	"seguradoEndereco": "Rua Segurado, 456",
	"seguradoNumero": "456",
	"seguradoComp": "Apto 101",
	"seguradoBairro": "Bairro Seguro",
	"seguradoCep": "12345-678",
	"seguradoCidade": "São Paulo",
	"seguradoEstado": "SP",
	"seguradoTelefone": "(11) 1234-5678",
	"seguradoCelular": "(11) 98765-4321",
	"seguradoEmail": "joao.silva@example.com",
	"seguroVidaNome": "Maria Souza",
	"seguroVidaIdade": "49",
	"seguroVidaValor": "100000",
	"seguroVidaCobertura": "Cobertura Completa",
	"seguroVidaBeneficiario": "João Souza",
	"pagamentoPremio": "2000",
	"pagamentoCusto": "50",
	"pagamentoJuros": "20",
	"pagamentoIof": "25",
	"pagamentoPremioTotal": "2095",
	"pagamentoFormaPagamento": "Cartão de Crédito",
	"pagamentoParcelas": "12",
	"corretorNome": "Corretor de Seguros",
	"corretorSusep": "789456",
	"corretorTelefone": "(11) 1234-5678",
	"corretorEmail": "corretorexample.com",
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
