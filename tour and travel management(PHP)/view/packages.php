<!DOCTYPE html>
<html>
<head>
	
	<title>PACKAGES</title>
    <link rel="stylesheet" href="style2.css">
	
</head>
<body>
	
	

	<table align="center">
<?php

header("Content-type: text/html");

?>

<h1 class = "title" align="center">PACKAGE LIST</h1>
<table align="center" border="2px" cellpadding="2px" cellspacing="4px">

<tr>

<th>SERIAL </th>

<th>PLACE </th>

<th>DAY</th>

<th>HOTEL</th>

<th>DATE</th>

<th>COST</th>

<th>Picture</th>

</tr>


<?php

require_once('../model/packagelist.php');
 $result=packagelist();
 if(mysqli_num_rows($result) > 0){
while ($row = mysqli_fetch_array($result)) {
	echo "<tr>";
	echo "<td>" . $row['serial'] . "</td>";
	echo "<td>" . $row['place'] . "</td>";
	echo "<td>" . $row['day'] . "</td>";
	echo "<td>" . $row['hotel'] . "</td>";
	echo "<td>" . $row['date'] . "</td>";
	echo "<td>" . $row['cost'] . "</td>";
	echo "<td><img src='" . $row['images'] . "'alt=' not found' width='100' height='100'></td>";
	
	echo "</tr>";

}
mysqli_free_result($result);
 }

?>

	</table>


<div class=create>
<form action="../controller/packagesaddcheak.php" method="post" enctype="multipart/form-data"onsubmit="return validatepackage()" >

			
	
				<table align="center">
				<h2>CREATE PACKAGES<h2/>
					<tr>
						<td>PLACE</td>
						<td><input type="text" id ="PLACE" name="PLACE" value=""></td>
					</tr>
					<tr>
						<td>DAY</td>
						<td><input type="text" id ="DAY" name="DAY" value=""></td>
					</tr>
					<tr>
						<td>HOTEL</td>
						<td><input type="text" id ="HOTEL" name="HOTEL" value=""></td>
					</tr>
					<tr>
						<td>DATE</td>
						<td><input type="text" id="DATE" name="DATE" value=""></td>
					</tr>
					<tr>
						<td>COST</td>
						<td><input type="text" id ="COST" name="COST" value=""></td>
					</tr>
					
					<tr>
						<td>select Image</td>
						<td><input type="file" name="filename" value=""></td>
						
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="create_box" id="submit" name="" value="CREATE" ></td>
					</tr>
					
					
				</table>
      
			

		</form>
</div>
<script>
            function validatepackage(){
                let PLACE = document.getElementById('PLACE').value;
				let DAY = document.getElementById('DAY').value;
				let HOTEL = document.getElementById('HOTEL').value;
				let DATE = document.getElementById('DATE').value;
				let COST = document.getElementById('COST').value;
				

                if(PLACE != ""){
                    return true;
                }else{
                    alert('INVALIDE INFFORMATION');
                    return false;
                }
				if(DAY != ""){
                    return true;
                }else{
                    alert('INVALIDE INFFORMATION');
                    return false;
                }
				if(HOTEL != ""){
                    return true;
                }else{
                    alert('INVALIDE INFFORMATION');
                    return false;
                }
				if(DATE != ""){
                    return true;
                }else{
                    alert('INVALIDE INFFORMATION');
                    return false;
                }
				if(COST != ""){
                    return true;
                }else{
                    alert('INVALIDE INFFORMATION');
                    return false;
                }
				
            }
        </script>
</table>
		<div class="delet_package">
	<form action="../controller/deletepackage.php" method="post" enctype="" onsubmit="return validatedelete()" >
		
		
				
				<table align="center">
					<tr>
						<h2>DELET PACKAGE<h2/>
						<td>SERIAL</td>
						<td><input type="text" id="SERIAL" name="SERIAL" value=""  required></td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" class="delet_box" name="" id ="submit" value="DELET" ></td>
					</tr>
				</table>

			

		</form>
		</div>
<div class="color2">
 <a href="../view/travelhome.php"> Back to home </a>
		</div>
        </body>
</html>