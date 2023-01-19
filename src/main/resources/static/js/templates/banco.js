//verificar se o documento está pronto para uso
document.addEventListener("DOMContentLoaded", function() {
    document.getElementById("cadastro").classList.add("show");
});

//verificar evento click do botão de excluir
document.getElementById("btnExcluir").addEventListener("click", function() {
    let myForm = document.querySelector("form");
    let idBanco = document.getElementById("idBanco").value;
    myForm.action = "/banco/" + idBanco;
    myForm.submit();
});