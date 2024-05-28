
<?php
if(!isset($_COOKIE['status'])){
     header('location: ../view/login.php');
}
?>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title></title>
</head>
<body>


<?php 
require_once('../model/trainlist.php');
	$EMAIL = $_REQUEST['email'];
	$PASSWORD = $_REQUEST['password'];
	

	if ($EMAIL == null || $PASSWORD == null  ) 
	{
		echo "<h1 align= center> PLEASE ADD INFORMATION <br>";
	}
	else 
	{
		$user['email']=$EMAIL;
		$user['password']=$PASSWORD;
		
		$status = Forgotpass($user);

	
		if(!$status)
		{
			$status2 = Forgotpass2($user);
             header('location: ../view/login.php');   
		}
		else 
	    {
			 header('location: ../view/login.php');   
	    }
		
	}
	


	
?>



<br/>
<div align="center"><a href="../view/train.php"> BACK </a></div>
</body>
</html>