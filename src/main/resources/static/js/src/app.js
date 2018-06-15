(function(){
   var app = angular.module('bookshelf-client', ['book-module', 'ngRoute']);

   var routesConfig = function ($routeProvider) {

              $routeProvider
                      .when('/books', {
                          controller: 'BookListController',
                          controllerAs: 'books',
                          templateUrl: 'books/list.html'
                      })
                      .when('/book/new', {
                          controller: 'BookEnrollController',
                          controllerAs: 'books',
                          templateUrl: 'books/form.html'
                      })
                      .when('/book/view/:id', {
                          controller: 'BookViewController',
                          controllerAs: 'books',
                          templateUrl: 'books/view.html'
                      })
                      .when('/book/edit/:id', {
                          controller: 'BookEnrollController',
                          controllerAs: 'books',
                          templateUrl: 'books/form.html'
                      })
                      .otherwise({ redirectTo: '/books' });

          };


      app.config(routesConfig);
})();


