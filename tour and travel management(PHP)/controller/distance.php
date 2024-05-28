<?php
if(!isset($_COOKIE['status'])){
    header('location: ../view/login.php');
}
?>
<?php


require_once('../model/distancelist.php');
$FROM = $_REQUEST['FROM'];
$TO=$_REQUEST['TO'];

if ($FROM == null || $TO == null) {
    echo "<h1 align= center> PLEASE ADD INFORMATION <br><div align=center><a href=train.php> BACK </a></div>";
    return ;
}else{
    $user['FROM']=$FROM;
    $user['TO']=$TO;
   
    require_once('../model/trainlist.php');
    $result=Disatance($user);
    if(mysqli_num_rows($result) > 0){
   while ($row = mysqli_fetch_array($result)) {
       
       echo  $row['distance'] ;
      
   }
   mysqli_free_result($result);
    }

    

}


?>