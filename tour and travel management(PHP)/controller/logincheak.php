<?php 
	
	require_once('../model/trainlist.php');

	$email = $_REQUEST['email'];
	$password = $_REQUEST['password'];

	if ($email == null || $password == null) {
		echo "invalid email/password <br>";
	}
	
    else {

        $status = login($email, $password);
        $status2 = login2($email, $password);
		$status3 = login3($email, $password);
		if($status)
		{
			setcookie('status', 'true', time()+3600, '/');
			header('location: ../view/travelhome.php');
		}
		else if($status2)
		{
			setcookie('status', 'true', time()+3600, '/');
	    	header('location: ../view/mim.html');	          
	    }
		else if($status3)
		{
			setcookie('status', 'true', time()+3600, '/');
	    	header('location: ../view/samin.html');	          
	    }
		else 
		{
			header('location: ../view/login.php');	
		}
}

?>