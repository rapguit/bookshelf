(function () {
    var bookModule = angular.module('book-module', ['ngRoute']);

    var bookListCrtl = function ($scope, $http, $location) {

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
            var url = window.location.origin + "/api/bookshelf/" + this.selected.isbn
            $http
                    .delete(url)
                    .then(function onSuccess(response) {
                        refreshList();
                    });
        };

        var refreshList = function () {
            var url = window.location.origin + "/api/bookshelf";
            $http.get(url)
                    .then(function onSuccess(response) {
                        $scope.bookList = response.data.bookshelf;
                    });
        };

        refreshList();
    };

     var bookEnrollCrtl = function ($scope, $http, $location, $routeParams) {
        var id = $routeParams.id;

        if (id) {
            var url = window.location.origin + "/api/bookshelf/"+id

            $http.get(url)
                    .then(function onSuccess(response) {
                        $scope.books.bookCandidate = response.data;
                    });
        } else {
            this.bookCandidate = {};
        }

        this.back = function () {
            $location.path('/bookshelf');
        };

        this.save = function () {
            var url = window.location.origin + "/api/bookshelf"
            if(this.bookCandidate.authors) this.bookCandidate.authors = this.bookCandidate.authors.split(',');
            $http
                    .post(url, this.bookCandidate)
                    .then(function onSuccess(response) {
                        $location.path('/book/view/' + response.data.isbn);
                    });

        };
    };

    var bookViewCrtl = function ($scope, $http, $location, $routeParams) {
        this.bookView = {};

        this.back = function () {
            $location.path('/bookshelf');
        };

        var id = $routeParams.id;
        var url = window.location.origin + "/api/bookshelf/"+id

        $http.get(url)
                .then(function onSuccess(response) {
                    $scope.books.bookView = response.data;
                });
    };

    bookModule.$inject = ['$scope', '$http', '$location', '$routeParams'];
    bookModule.controller('BookListController', bookListCrtl);
    bookModule.controller('BookEnrollController', bookEnrollCrtl);
    bookModule.controller('BookViewController', bookViewCrtl);
})();


