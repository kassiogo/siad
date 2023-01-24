/**
 * Criar objetos que correspondem aos inputs do formulário.
 */
const nome = document.getElementById("nome");
const cnpj = document.getElementById("cnpj");
const cpf = document.getElementById("cpf");
const divCnpj =  document.getElementById("divCnpj");
const divCpf =  document.getElementById("divCpf");


/**
 * Verificar se o documento está pronto para uso e realizar as inicializações necessárias.
 */
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("cadastro").classList.add("show"); //abrir o menu de configuração
    nome.focus(); // Configurar foco no campo nome assim que a página abrir
});


/***
 * Adicionar um listener para o evento click em cada um dos inputs com a classe ".tipoPessoa".
 */
document.querySelectorAll('.tipoPessoa').forEach((item) => {
  item.addEventListener('click', () => {
	const tipoPessoa = item.value; // Criar uma constante com o valor do input radio que está sendo selecionado.
	if (tipoPessoa === '1' || tipoPessoa === '4') { // Valor 1 ou 4 -> mostrar o campo CPF. 
		divCnpj.classList.add("d-none"); // Usar classe Bootstrap para tornar a div invisível.
		cnpj.value = "";
		divCpf.classList.remove("d-none"); // Retirar classe Bootstrap que tornava a div invisível.
		return; // Tudo que precisava ser feito foi feito e a função deve ser interrompida aqui.
	}
	// Se a execução do código chegar nesse ponto é porque não entrou no If acima e o valor do tipoPessoa só pode ser 2 ou 3 -> estes valores habilitam o campo CNPJ.
	divCnpj.classList.remove("d-none");
	divCpf.classList.add("d-none");
	cpf.value = "";
  });
});