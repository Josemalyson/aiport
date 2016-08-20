var btsalvar = $('#salvar');

btsalvar.prop("disabled", true);

var senha = $('#senha');
var confirmarSenha = $('#confirmarSenha');

confirmarSenha.blur(function() {
	if (senha.val() !== confirmarSenha.val()) {
		senha.val(null);
		confirmarSenha.val(null);
		$('#modal').click();
		btsalvar.prop("disabled", true);
		$('#conteudo').html("<p>Senha não confere com a digitada.</>");
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
	$("#data").datepicker();
});

function atualizar() {

	if ($('#tipoDocumento').val() != '' && $('#tipoDocumento').val() != null) {
		
		if ($('#tipoDocumento').val() == 1) {
			$("#a").text("Numero do CPF");
			$("#cpf").mask("999.999.999-99", {
				placeholder : "_"
			});
			
		} else {
			$("#a").text("Numero do RG");
			$("#cpf").mask("99.999.9-9", {placeholder : "_"});
		}
	}
}