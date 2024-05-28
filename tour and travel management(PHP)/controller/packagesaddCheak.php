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
require_once('../model/packagelist.php');
	$PLACE = $_REQUEST['PLACE'];
	$DAY = $_REQUEST['DAY'];
	$HOTEL = $_REQUEST['HOTEL'];
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
	if ($PLACE == null || $DAY == null || $HOTEL == null || $COST == null || $DATE == null || $filename == null || $tmp_loc == null ) {
		echo "<h1 align= center> PLEASE ADD INFORMATION <br>";
	}else{
		$user['place']=$PLACE;
		$user['day']=$DAY;
		$user['hotel']=$HOTEL;
		$user['date']=$DATE;
		$user['cost']=$COST;
		$user['file_location']=$uploc.$filename;
		addpackage($user);

		echo "<h1 align= center> CREATE NEW  SUCCESSFULLY <h1/>";
	}
	header('location: ../view/packages.php');
?>


<br/>
<div align="center"><a href="../view/packages.php"> BACK </a></div>
</body>
</html>