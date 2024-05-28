
<?php 
require_once('db.php');
function Disatance($user){
    
    $conn = getConnection();
    $sql = "select distance from distance_info where leaving_from like '{$user['FROM']}' and  going_to like '{$user['TO']}'";
    
    
 $result = mysqli_query($conn, $sql);
	
    mysqli_close($conn);
   return $result;
}
