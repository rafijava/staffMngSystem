contactApp = angular.module("app", []);

contactApp.controller("HttpCtrl", function ($scope, $http) {
    $scope.navTitle = 'All Staff Member';
    $scope.operation = "";
    $scope.isSaveDisabled = true;
    $scope.isDeleteDisabled = true;

    var response = $http.get('/StaffMgsRESTFulMysql/rest/demo/');
    response.success(function (data) {
        angular.forEach(data, function (element) {
            console.log("[main] staff: " + element.email);
        });
        $scope.staffs = data;
        console.log("[main] # of items: " + data.length)

    })
    response.error(function (data, status, headers, config) {
        alert("AJAX failed to get data, status=" + status);
    })

    $scope.getStaff = function (id) {
        var response = $http.get('/StaffMgsRESTFulMysql/rest/demo/' + id);

        response.success(function (data) {
            console.log("getStaff data: " + angular.toJson(data, false));
          
            $scope.staff = data;
            $scope.operation = "update";
            $scope.isSaveDisabled = false;
            $scope.isDeleteDisabled = false;
        })

        response.error(function (data, status, headers, config) {
            alert("AJAX failed to get data, status=" + status);
        })
    };

    $scope.searchStaff = function (name) {
        $scope.navTitle = 'Search Criteria';

        var response = $http.get('/StaffMgsRESTFulMysql/rest/demo/search/' + name);
        response.success(function (data) {
            $scope.staffs = data;
            $scope.$apply();

            console.log("[searchStaff] # of items: " + data.length)
            angular.forEach(data, function (element) {
                console.log("[searchStaff] staff: " + element.name);
            });

        });

        response.error(function (data, status, headers, config) {
            alert("AJAX failed to get data, status=" + status);
        })
    };
    $scope.clearForm = function () {
        $scope.staff = {
            id: '',
            active: '',
            birthDate: '',
            joiningDate: '',
            email: '',
            image: '',
            name: ''
        };
    }

    $scope.addNew = function (element) {
        $scope.operation = "create";
        $scope.clearForm();
        main.id.focus();
        $scope.isSaveDisabled = false;
        $scope.isDeleteDisabled = true;
    }

    $scope.saveStaff = function (id) {
        $scope.jsonObj = angular.toJson($scope.staff, false);
        console.log("[update] data: " + $scope.jsonObj);

        if ($scope.operation == "update") {
            var response = $http.put('/StaffMgsRESTFulMysql/rest/demo/' + id, $scope.jsonObj);
            response.success(function (data, status) {
                console.log("Inside update operation..." + angular.toJson(data, false) + ", status=" + status);
                $scope.resetSearch();
            });

            response.error(function (data, status) {
                alert("AJAX failed to get data, status=" + status);
            })
        } else if ($scope.operation == "create") {
            var response = $http.post('/StaffMgsRESTFulMysql/rest/demo/add', $scope.jsonObj);
            response.success(function (data, status) {
                console.log("Inside create operation..." + angular.toJson(data, false) + ", status=" + status);
                $scope.resetSearch();
            });

            response.error(function (data, status) {
                alert("AJAX failed to get data, status=" + status, scope);
            })
        }
    };

    $scope.deleteStaff = function (id) {
        var response = $http.delete('/StaffMgsRESTFulMysql/rest/demo/' + id);
        response.success(function (data, status) {
            console.log("Inside delete operation..." + angular.toJson(data, false) + ", status=" + status);
            $scope.resetSearch();
        });

        response.error(function (data, status) {
            alert("AJAX failed to get data, status=" + status);
        })
    };

    $scope.resetSearch = function (name) {
        //var app = this;
        $scope.operation = "";
        $scope.clearForm();
        $scope.isSaveDisabled = true;
        $scope.isDeleteDisabled = true;
        $scope.navTitle = 'All Staff Member';
        $scope.searchName = '';

        var response = $http.get('/StaffMgsRESTFulMysql/rest/demo/');
        response.success(function (data) {
            $scope.staffs = data;
            //$scope.$apply();
            console.log("[resetSearch] # of items: " + data.length)
        });

        response.error(function (data, status, headers, config) {
            alert("AJAX failed to get data, status=" + status);
        })
    };

});
