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
	$LEAVING = $_REQUEST['LEAVING'];
	$GOING = $_REQUEST['GOING'];
	$TIME = $_REQUEST['TIME'];
	$DATE = $_REQUEST['DATE'];
	$COST = $_REQUEST['COST'];
	
	if ($SERIAL == null || $LEAVING == null || $GOING == null || $TIME == null || $DATE == null || $COST == null) {
		echo "<h1 align= center> PLEASE ADD INFORMATION <br><div align=center><a href=train.php> BACK </a></div>";
		return ;
	}else{
        $user['serial']=$SERIAL;
		$user['leaving_from']=$LEAVING;
		$user['going_to']=$GOING;
		$user['time']=$TIME;
		$user['date']=$DATE;
		$user['cost']=$COST;
       

		updatetrip($user);
	
	}

  echo "<h1 align= center > UPDATE SUCCESSFULLY <h1> <br>";
  header("location: ../view/train.php");
?>

<div align="center"><a href="../view/train.php"> BACK </a></div>
</body>
</html>