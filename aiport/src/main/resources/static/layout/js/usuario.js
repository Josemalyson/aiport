$( window ).load(function() {
	if($('#tipoDocumento').val() == "" || $('#tipoDocumento').val() == null){
		$("#cpf").css("display", "none");
		$("#a").css("display", "none");
		$('#tipoDocumento').focus();
	}
});

var btsalvar = $('#salvar');

btsalvar.prop("disabled", true);

var senha = $('#senha');
var confirmarSenha = $('#confirmarSenha');

confirmarSenha.blur(function() {

	if (senha.val() == null || senha.val() == ""
			&& confirmarSenha.val() == null || confirmarSenha.val() == "") {
		btsalvar.prop("disabled", true);
		abrirModal("<p>Senha não pode ser vazia.</>");
	} else if (senha.val() !== confirmarSenha.val()) {
		senha.val(null);
		confirmarSenha.val(null);
		btsalvar.prop("disabled", true);
		abrirModal("<p>Senha não confere com a digitada.</>");
	} else {
		btsalvar.prop("disabled", false);
	}

});

$(function() {
	jQuery(function($) {
		$("#data").mask("99/99/9999", {
			placeholder : "_"
		});
	});
});

function atualizar() {

	if ($('#tipoDocumento').val() != '' && $('#tipoDocumento').val() != null) {

		if ($('#tipoDocumento').val() == 2) {
			$("#cpf").css("display", "block");
			$("#a").css("display", "block");
			$("#a").text("Numero do CPF");
			$("#cpf").mask("999.999.999-99", {
				placeholder : "_"
			});

		} else if ($('#tipoDocumento').val() == 1) {
			$("#cpf").css("display", "block");
			$("#a").css("display", "block");
			$("#a").text("Numero do RG");
			$("#cpf").mask("99.999.9-9", {
				placeholder : "_"
			});
		}
	} else {
		$("#cpf").css("display", "none");
		$("#a").css("display", "none");
		$('#tipoDocumento').focus();
		abrirModal("<p>Selecione ao menos um tipo de documento</>");
	}
}

function abrirModal(texto){
	$('#modal').click();
	$('#conteudo').html(texto);
}

