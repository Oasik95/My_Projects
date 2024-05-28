
<?php

?>
<!DOCTYPE html>
<html>
<head>
	
<link rel="stylesheet" href="style3.css">
	<title>Email Check</title>
</head>
<body>
<div class="s2">
<form action="../controller/fpasscheak.php" method="POST" class="login-email" onsubmit="return valid()">
			<h2>Forgot Password</h2>
			<tr>
				<td><input type="email" placeholder="Email" name="email" value="" required></td></br></br>
			</tr>
			<tr>
				<td><input type="password" placeholder="Password" name="password" value="" id="Show" required><input type="checkbox" placeholder="" name="" onclick="myFunction()" value="" ></br></br>
                <tr>
				<td><input type="password" placeholder="Confirm Password" name="cpassword" value="" id="show2" required></td>
                <td><label style ="color:red;" id="pass" ></label></td>
            </tr>
            </tr>
				<tr>
				
                <td><input type="checkbox" placeholder="" name="" onclick="myFunction2()" value="" ></td></br>
            </tr>
               
				<script >
					function myFunction()
					{
						var show=document.getElementById('Show')
						if(show.type=='password')
						{
							show.type='text';
                            
						}
						else
						{
							show.type='password';

						}
					}
                    function myFunction2()
					{
						var show=document.getElementById('show2')
						if(show.type=='password')
						{
							show.type='text';
                            
						}
						else
						{
							show.type='password';

						}
					}
				</script>
				
			
			<div class="btn">
				</br><input type="submit" name="submit" value="submit" >
                <a href="../view/login.php"> Back </a>
			</div>
		</form>
        <script>
            function valid(){
                var password=document.getElementById('Show').value;
                var cpassword=document.getElementById('show2').value;
                if(password !== cpassword){
             document.getElementById('pass').innerHTML = "! password should be same ";
             return false;
             }
            }
            </script>
                </div>
</body>
</html>
	
