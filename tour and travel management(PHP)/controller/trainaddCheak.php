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
	$LEAVING = $_REQUEST['LEAVING'];
	$GOING = $_REQUEST['GOING'];
	$TIME = $_REQUEST['TIME'];
	$DATE = $_REQUEST['DATE'];
	$COST = $_REQUEST['COST'];
	$filename = $_FILES['filename']['name'];
	$tmp_loc =$_FILES['filename']['tmp_name'];

	$uploc = '../images/';
	if(!empty($filename)){
		move_uploaded_file($tmp_loc,$uploc.$filename);
	}else{
		echo 'select a file';
	}
	if ($LEAVING == null || $GOING == null || $TIME == null || $DATE == null || $COST == null || $filename == null || $tmp_loc == null ) {
		echo "<h1 align= center> PLEASE ADD INFORMATION <br>";
	}else{
		$user['leaving_from']=$LEAVING;
		$user['going_to']=$GOING;
		$user['time']=$TIME;
		$user['date']=$DATE;
		$user['cost']=$COST;
		$user['file_location']=$uploc.$filename;
		addtrip($user);

		echo "<h1 align= center> NEW TRIP ADDED SUCCESSFULLY <h1/>";
	}

	header("location: ../view/train.php");
?>



<br/>
<div align="center"><a href="../view/train.php"> BACK </a></div>
</body>
</html>