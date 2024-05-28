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
	$SERIAL = $_REQUEST['SERIAL'];
    $STATUS = $_REQUEST['status'];
	
	if ($SERIAL == null || $STATUS ==null ) {
		echo "<h1 align= center> PLEASE ADD INFORMATION <br><div align=center><a href=train.php> BACK </a></div>";
		return ;
	}else{
        $user['serial']=$SERIAL;
        $user['status']=$STATUS;
		status($user);
	
	}

 
 
?>

<div align="center"><a href="../view/train.php"> confirm? </a></div>
</body>
</html>