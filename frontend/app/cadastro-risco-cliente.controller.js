'use strict'
angular.module('cadastroriscocliente.module', []).controller('cadastroriscocliente.controller', ['$scope', 'cadastroriscocliente.service', constructor])

function constructor($scope, cadastroRiscoClienteService) {

	$scope.salvarCadastroClienteRisco = function() {
		const cadastroRiscoClienteDto = {
			nomeCliente: $scope.nomeCliente,
			limiteCreditoCliente: $scope.limiteCreditoCliente,
			riscoCliente: $scope.riscoCliente
		}
		cadastroRiscoClienteService.cadastrarClienteRisco(cadastroRiscoClienteDto).then(
			function() {
				$("#successmsg").show()
				$('#successmsg').delay(4000).fadeOut('slow')
			},
			function() {
				$("#errormsg").show()
				$('#errormsg').delay(4000).fadeOut('slow')
			}
		)
	}

}
