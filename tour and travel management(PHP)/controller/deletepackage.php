<?php
if(!isset($_COOKIE['status'])){
    header('location: ../view/login.php');
}
?>
<!DOCTYPE html>
<html>
<head>
	
	<title></title>
</head>
<body>
<?php
   require_once('../model/packagelist.php');
   $SERIAL = $_REQUEST['SERIAL'];	


   if ($SERIAL == null ) {
		echo "<h1 align= center> PLEASE ADD INFORMATION <br><div align=center><a href=../view/packages.php> BACK </a></div>";
		return ;
}else{
    $user['serial']=$SERIAL;
		

	deletepackage($user);
}
header('location: ../view/packages.php');
?>
<div align="center"><a href="../view/packages.php"> BACK </a></div>
</body>
</html>