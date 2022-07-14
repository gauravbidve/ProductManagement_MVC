<jsp:include page="menu.jsp"/>

<html>

<head>

    <title>Add User</title>

    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

    <!--Bootsrap 4 CDN-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
        integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!--Fontawesome CDN-->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css"
        integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!--Custom styles-->
    <link rel="stylesheet" type="text/css" href="resources/css/regstyles.css">

</head>

<body>
    <form action="addUser" method="post">
        <div class="container register">
            <div class="row">
                <div class="col-md-3 register-left">
                    <h3>Welcome</h3>
                    <p>Add all the Details for the Registration</p>
                </div>
                <div class="col-md-9 register-right">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <h3 class="register-heading">ADD USER</h3>
                            <h4 style="color:red;">${msg}</h4>
                            <div class="row register-form">
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Username *" value=""
                                            name="username" required/>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Password *" value=""
                                            name="password" required/>
                                    </div>
                                    <div class="form-group">
                                        <div class="maxl">
                                            <span>Select Gender:</span><br>
                                            <label class="radio inline">
                                                <input type="radio" name="gender" value="male" checked>
                                                <span> Male </span>
                                            </label>
                                            <label class="radio inline">
                                                <input type="radio" name="gender" value="female">
                                                <span>Female </span>
                                            </label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <div class="form-group">
                                        <select class="form-control" name="role">
                                            <option class="hidden" selected disabled>Your Role</option>
                                            <option>Admin</option>
                                            <option>User</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <select class="form-control" name="question">
                                            <option class="hidden" selected disabled>Security Question</option>
                                            <option>What is your Birthdate?</option>
                                            <option>What is Your old Phone Number</option>
                                            <option>What is your Pet Name?</option>
                                        </select>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Enter Your Answer *"
                                            value="" name="answer" />
                                    </div>
                                    <input type="submit" class="btnRegister" value="Add User" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</body>

</html>