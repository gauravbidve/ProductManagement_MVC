<jsp:include page="menu.jsp"/>

<html>
<head>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!------ Include the above in your HEAD tag ---------->

<title>Import User</title>

<script type="text/javascript">
function checkfile(sender){
	var validExts = new Array(".xls",".xlsx");
	var fileExt = sender.value;
	fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
	if(validExts.indexOf(fileExt)<0){
		alert("Invalid file selected, valid files are "+ validExts.toString() + " types.");
		sender.value="";
		return false;
	}else{
		return true;
	}
}
</script>

</head>

<body>
<div class="container form-data">
	<form id="fileUploadForm" 
      action="uploadUserSheet"
      method="post"
      enctype="multipart/form-data">
  <br> <input id="file" type="file" name="file" class="form-data" onchange="checkfile(this);" accept="application/xls" required/>
<button id="upload-button" type="submit" class="btn btn-primary"> Upload & Insert </button> 
</form>
<h2>${msg}</h2>
</div>
</body>
</html>