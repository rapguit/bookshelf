(function(){
   var app = angular.module('bookshelf-client', ['book-module', 'ngRoute']);

    var routesConfig = function ($routeProvider) {

           $routeProvider
               .when('/books', {
                   controller: 'BookController',
                   controllerAs : 'books',
                   templateUrl: 'book/list.html'
               })
               .otherwise({ redirectTo: '/books' });

      };

      app.config(routesConfig);
})();


