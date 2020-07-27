(function(angular) {
    angular.module("random_number.controllers", []);
    angular.module("random_number.services", []);
    angular.module("random_number", ["ngResource", "random_number.controllers", "random_number.services"]);
}(angular));