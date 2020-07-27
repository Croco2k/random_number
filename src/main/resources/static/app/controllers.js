(function (angular) {
    var RandomNumberController = function ($scope, RandomNumber) {

        RandomNumber.query(function (response) {
            $scope.randomNumbers = response ? response : [];
        });

        $scope.incorrectInput = "";
        $scope.nullNickname = "";
        $scope.addRandomNumber = function (nickname, numberFrom, numberTo) {
            if(numberFrom >= numberTo) {
                $scope.incorrectInput = "Проверьте введенное число";
                return;
            }
            if(nickname == null) {
                $scope.nullNickname = "Ник не может быть пустым";
                return;
            }
            var value = $scope.getRandomNumber(numberFrom, numberTo);
            alert("Случайное число " + value);
            new RandomNumber({
                nickname: $scope.validation(nickname),
                value: value,
                createDate: new Date()
            }).$add(function (result) {
                $scope.randomNumbers.unshift(result);
                if($scope.randomNumbers.length > 5)
                    $scope.randomNumbers.pop();
            });
            $scope.clearModels();
        };

        $scope.updateRandomNumber = function(randomNumber, newNickname) {
            new RandomNumber({
                id: randomNumber.id,
                value: randomNumber.value,
                createDate: randomNumber.createDate,
                nickname: $scope.validation(newNickname) ? newNickname : randomNumber.nickname
            }).$update(function () {
                $scope.randomNumbers = RandomNumber.query();
            });
        };

        $scope.deleteRandomNumber = function(randomNumber) {
            randomNumber.$remove(function () {
                $scope.randomNumbers = RandomNumber.query();
            });
        };

        $scope.getRandomNumber = function (numberFrom, numberTo) {
            numberFrom = Math.ceil(numberFrom);
            numberTo = Math.floor(numberTo);
            return Math.floor(Math.random() * (numberTo - numberFrom + 1)) + numberFrom;
        };

        $scope.validation = function (param) {
            return !(typeof param === "undefined" || param === null || param === "");
        };

        $scope.clearModels = function () {
            $scope.nickname = "";
            $scope.numberFrom = "";
            $scope.numberTo = "";
            $scope.incorrectInput = "";
        };

    };
        RandomNumberController.$inject = ['$scope', 'RandomNumber'];
        angular.module("random_number.controllers").controller("RandomNumberController", RandomNumberController);
}(angular));