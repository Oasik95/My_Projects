<?php
if(!isset($_COOKIE['status'])){
    header('location: ../view/login.php');
}
?>
<?php 

    $host = "localhost";
    $dbname = "travelmanagement";
    $dbpass = "";
    $dbuser = "root";

    function getConnection(){
        global $host;
        global $dbname;
        global $dbpass;
        global $dbuser;

        $conn = mysqli_connect($host, $dbuser, $dbpass, $dbname);
        return $conn;
    
    }
    function closeConnection(){
        
    }
?>