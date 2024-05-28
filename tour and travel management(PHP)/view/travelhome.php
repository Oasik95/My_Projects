<?php
if(!isset($_COOKIE['status'])){
	header('location: ../view/login.php');
}
?>

<!DOCTYPE html>
<html>
<head>
	
	<title>HOME</title>
	
    <style >
	
	
	#s1{
	background-color:#639e63;
	color:white;
	}
	#s1 a{
	background-color:#639e63;
	color:white;
	}
	#s2{
	background-color:#639e63;
	color:white;
	 width:900px;
	 margin:0 auto;
	}
	
       #nav-menu{
	   width:370px;
	   height:70px;
	   background-color:#639e63;
	   margin:0 auto;
	   }
	   #nav-menu ul li{
	   list-style-type:none;
	   margin:20px;
	   float:left;
	   }
	   #nav-menu ul li a{
	   text-decoration:none;
	   font-size:25px;
	   color:white;
	  
	 
	   }
	    #nav-menu2{
	   width:230px;
	   height:70px;
	   background-color:#639e63;
	   margin:0 auto;
	   }
	   #nav-menu2 ul li a{
	   text-decoration:none;
	   font-size:25px;
	   color:white;
	   
	   }
	   #nav-menu2 ul li {
	   list-style-type:none;
	   margin:20px;
	   float:left;
	   }
	   
	  
    </style>
</head>

<body>
  <div id="s1"> 
	<h1 align="center">WELCOME TO TRAVEL MANAGEMENT</h1><h3><a  href="../controller/logout.php">  < < LOGOUT </a></h3>
	</div>
<div id="s2"> 
   <h3 align="center"> Please choose your option<h3> 
   </div>
    <div id="nav-menu">
        <ul>
            <li><a  href="../view/train.php"> MANAGE TRANSPORT </a></li>
          
           
        </ul>
    </div>
	<div id="nav-menu2">
        <ul>
            <li><a  href="../view/packages.php"> PACKAGES </a></li>
            
        </ul>
    </div>
 
	
    
	

</body>
</html>
