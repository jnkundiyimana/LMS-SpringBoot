
var lmsApp = angular.module("lmsApp", ["ngRoute"]);

lmsApp.config(["$routeProvider", function($routeProvider){
	return $routeProvider.when("/", {
		redirectTo: "/lms/home"
	}).when("/lms/home", {
		templateUrl: "views/welcome.html"
	}).when("/lms/admin", {
		templateUrl: "views/admin/admin.html"
	}).when("/lms/admin/author", {
		templateUrl: "views/admin/author.html"
	}).when("/lms/admin/viewauthors", {
		templateUrl: "views/admin/viewauthors.html"
	})
}])


lmsApp.controller("authorController", function($scope, $http){
	
	$http.get("http://localhost:8080/readAuthors").success(function(data){
		$scope.authors = data;
	})
	
	 
	$scope.deleteAuthor = function(authorId){
		var author = { "authorId": authorId};
		$http.delete("http://localhost:8080/deleteAuthor", authorId).success(function(data){
			$http.get("http://localhost:8080/readAuthors").success(function(data){
				$scope.authors = data;
			})
		})
	}
	
	$scope.popEditModal = function(a){
		$scope.editAuthor = a; 
	}
	
	
	$scope.updateAuthor = function(authorId){
		var author = { "authorId": authorId};
		$http.put("http://localhost:8080/updateAuthor", author).success(function(data){
			$http.get("http://localhost:8080/readAuthors").success(function(data){
				$scope.authors = data;
			})
		})
	}
	
}) 