<?php
if(!isset($_COOKIE['status'])){
	header('location: ../view/login.php');
}
?>
<?php 
	session_start();
	require_once('../model/traveluserslist.php');

	if(isset($_REQUEST['submit']))
	{
		$name=$_REQUEST['name'];
		$gender=$_REQUEST['gender'];
		$dob=$_REQUEST['dob'];
		$email=$_REQUEST['email'];
		$password=$_REQUEST['password'];
		$address=$_REQUEST['address'];
        $cardnumber=$_REQUEST['cardnumber'];
        $country=$_REQUEST['country'];
		

		if($password <= 3)
			{
				echo "Password required length greater than 3";
			}
		
        else if($name == null || $gender == null || $dob == null || $email == null || $password == null  || $address == null || $cardnumber == null || $country == null)
		{
			echo "invalide info";
		}
		
		else
		{
            $user['name']=$name;
            $user['gender']=$gender;
            $user['dob']=$dob;
            $user['email']=$email;
            $user['password']=$password;
			$user['address']=$address;
            $user['cardnumber']=$cardnumber;
            $user['country']=$country;
            signup($user);
    			
		}
		
	}	
     header("location: ../view/login.php");
?>