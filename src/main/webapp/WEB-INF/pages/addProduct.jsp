<jsp:include page="menu.jsp"/>

<html>

<head>

    <title>Add Product</title>

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
    <form action="addProduct" method="post">
        <div class="container register">
            <div class="row">
                <div class="col-md-3 register-left">
                    <h3>Welcome</h3>
                    <p>Fill all the Details to add the Product</p>
                </div>
                <div class="col-md-9 register-right">
                    <div class="tab-content" id="myTabContent">
                        <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                            <h3 class="register-heading">ADD PRODUCT</h3>
                            <h4 style="color:red;font-size=5px;">${msg}</h4>
                            <div class="row register-form">
                                <div class="col">                                
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Product Name *" value=""
                                            name="productName" required/>
                                    </div>
                                    <div class="form-group">
                                        <input type="text" class="form-control" placeholder="Product Price *" value=""
                                            name="productPrice" required/>
                                    </div>
                                    <div class="form-group">
                                        <input type="date" class="form-control" placeholder="Product ExpiryDate *" value=""
                                            name="productExpiryDate" required/>
                                    </div>
                                </div>
                                    <input type="submit" class="btnRegister" value="Add Product" />
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
    </form>
</body>

</html>