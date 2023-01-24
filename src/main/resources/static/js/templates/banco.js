document.addEventListener("DOMContentLoaded", function() { //verificar se o documento está pronto para uso
    document.getElementById("cadastro").classList.add("show"); //abrir o menu de configuração
});

//verificar evento click do botão de excluir
document.getElementById("btnExcluir").addEventListener("click", function() {
    let myForm = document.querySelector("form");
    let idBanco = document.getElementById("idBanco").value;
    myForm.action = "/banco/remove/" + idBanco;
    myForm.submit();
});