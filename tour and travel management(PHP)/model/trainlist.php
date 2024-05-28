<?php
if(!isset($_COOKIE['status'])){
    header('location: ../view/login.php');
}
?>
<?php 

   
 require_once('db.php');
function traintriplist( $target_page){
    $conn = getConnection();
	$sql = "select * from train limit $target_page,3 ";
	$result = mysqli_query($conn, $sql);
    mysqli_close($conn);
   return $result;
}
function row_count( ){
    $conn = getConnection();
	$sql = "select * from train ";
	$result = mysqli_query($conn, $sql);
    $count=mysqli_num_rows($result);
    mysqli_close($conn);
   return $count;
}
function addtrip($user){
    
    $conn = getConnection();
    
	$sql = "insert into train  ( leaving_from, going_to, time, date,cost,upload_location) values( '{$user['leaving_from']}', '{$user['going_to']}','{$user['time']}','{$user['date']}','{$user['cost']}','{$user['file_location']}')";

    if(mysqli_query($conn, $sql)){
        return ;
    }else{
        return false;
    }
}
function deletetrip($user){
    $conn = getConnection();
    
	$sql = "delete from train where serial={$user['serial']}";
    

    if(mysqli_query($conn, $sql)){
        return ;
    }else{
        return false;
    }
}
function updatetrip($user){
    $conn = getConnection();
    
	$sql = "update train SET  leaving_from='{$user['leaving_from']}',going_to='{$user['going_to']}',time='{$user['time']}',date='{$user['date']}',cost='{$user['cost']}' WHERE serial= {$user['serial']}";
    

    if(mysqli_query($conn, $sql)){
        return ;
    }else{
        return false;
    }
}
function searchtrip($user){
    
    $conn = getConnection();
    $sql = "select * from train where going_to like '%{$user['SEARCH']}%'";
    
    
 $result = mysqli_query($conn, $sql);
	
    mysqli_close($conn);
   return $result;
}



function login( $email, $password){
    $conn = getConnection();
	$sql = "select * from travelusers where email='{$email}' and password='{$password}'";
	$result = mysqli_query($conn, $sql);
	$count = mysqli_num_rows($result);

    if($count >0 ){
        return true;
    }else{
        return false;
    }
}
function login2( $email, $password){
    $conn = getConnection();
	$sql = "select * from users where Email='{$email}' and Password='{$password}'";
	$result = mysqli_query($conn, $sql);
	$count = mysqli_num_rows($result);

    if($count >0 ){
        return true;
    }else{
        return false;
    }
}
function login3( $email, $password){
    $conn = getConnection();
	$sql = "select * from admin where Email='{$email}' and Password='{$password}'";
	$result = mysqli_query($conn, $sql);
	$count = mysqli_num_rows($result);

    if($count >0 ){
        return true;
    }else{
        return false;
    }
}
function Forgotpass($user){
    $conn = getConnection();
    
	$sql = "update travelusers SET  password='{$user['password']}' WHERE email= '{$user['email']}'";
    

    if(mysqli_query($conn, $sql)){
        return ;
    }else{
        return false;
    }
}
function Forgotpass2($user){
    $conn = getConnection();
    
	$sql = "update users SET  Password='{$user['password']}' WHERE Email= '{$user['email']}'";
    

    if(mysqli_query($conn, $sql)){
        return ;
    }else{
        return false;
    }
}
function status($user){
    $conn = getConnection();
    
	$sql = "update train SET  status='{$user['status']}' WHERE serial= {$user['serial']}";
   
    if(mysqli_query($conn, $sql)){
        return ;
    }else{
        return false;
    }
}

