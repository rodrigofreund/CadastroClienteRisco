'use strict'
angular.module('cadastroriscocliente.module').factory('cadastroriscocliente.service', ['$http', constructor])

function constructor($http) {

    var service = {};

    service.cadastrarClienteRisco = function cadastrarClienteRisco(param) {
        return $http.put('http://localhost:8081/CadastroRisco/cadastrarClienteRisco', param)
    }

    return service;

}