(function () {
    var bookModule = angular.module('book-module', ['ngRoute']);

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
                });

    };

    bookModule.config(routesConfig);

    var bookListCrtl = function ($scope, $http, $location) {
        var headers = "";

        this.new = function () {
            $location.path('/book/new');
        };

        this.view = function (id) {
            $location.path('/book/view/' + id);
        };

        this.edit = function (id) {
            $location.path('/book/edit/' + id);
        };

        this.select = function (book) {
            this.selected = book;
        };

        this.delete = function () {
            var url = jarvisCoreModule.getServicePath("book", "delete/" + this.selected.isbn);
            var url = jarvisCoreModule.getServicePath("book", "delete/" + this.selected.isbn);
            $http
                    .delete(url, headers)
                    .success(function (data) {
                        refreshList();
                    });
        };

        var refreshList = function () {
            $http.get(url, headers)
                    .success(function (data) {
                        $scope.bookList = data;
                    });
        };

        refreshList();
    };

     var bookEnrollCrtl = function ($scope, $http, $location, $routeParams) {
        var id = $routeParams.id;
        var headers = "";

        if (id) {
            var url = jarvisCoreModule.getServicePath("book", id);

            $http.get(url, headers)
                    .success(function (data) {
                        $scope.books.bookCandidate = data;
                    });
        } else {
            this.bookCandidate = {};
        }

        this.back = function () {
            $location.path('/bookshelf');
        };

        this.save = function () {
            var url = jarvisCoreModule.getServicePath("book", "save");

            $http
                    .post(url, this.bookCandidate, headers)
                    .success(function (data) {
                        $location.path('/book/view/' + data.isbn);
                    });

        };
    };

    var bookViewCrtl = function ($scope, $http, $location, $routeParams) {
        this.bookView = {};

        this.back = function () {
            $location.path('/bookshelf');
        };

        var id = $routeParams.id;
        var url = jarvisCoreModule.getServicePath("book", id);
        var headers = "";

        $http.get(url, headers)
                .success(function (data) {
                    $scope.books.bookView = data;
                });
    };

    bookModule.$inject = ['$scope', '$http', '$location', '$routeParams'];
    bookModule.controller('BookListController', bookListCrtl);
    bookModule.controller('BookEnrollController', bookEnrollCrtl);
    bookModule.controller('BookViewController', bookViewCrtl);
})();


