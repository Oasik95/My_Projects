
<?php 

   
require_once('db.php');
function signup($user){
    
    $conn = getConnection();
    
	$sql = "insert into travelusers  (name,gender,dob,email,password,address,cardnum,country) values( '{$user['name']}', '{$user['gender']}','{$user['dob']}','{$user['email']}','{$user['password']}','{$user['address']}','{$user['cardnumber']}','{$user['country']}')";

    if(mysqli_query($conn, $sql)){
        return ;
    }else{
        return false;
    }
}