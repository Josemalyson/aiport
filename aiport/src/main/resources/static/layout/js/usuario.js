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
	jQuery(function($){
		   $("#data").mask("99/99/9999",{placeholder:" "});
		});
	$("#data").datepicker();
});
