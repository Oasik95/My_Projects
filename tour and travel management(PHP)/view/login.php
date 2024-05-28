<?php 

	
?>
<!DOCTYPE html>
<html>
<head>
	

	<title>Login Form</title>
    <style>
       #s1
       {
        width: 310px;
        height: 300px;
        box-shadow: 0 0 3px 0 rgba(0,0,0,0,.3); 
        background:rgb(233, 226, 226);
        padding: 25px;
        margin:7% auto 0 ;
        text-align: left;
        background-position: left;
        border-radius: 5%;
       }
       #s1 h1
       {
        width: 310px;
        text-align: center;
        background-color:#639e63;
        color: #fff;
        
       }
      
    </style>
    
</head>
<body>
    <div id ="s1"> 
	
		<form action="../controller/loginCheak.php" method="POST" class="login-email">
			<h1>Login</h1>
			<tr>
				<td><input type="email" placeholder="Email" name="email" value="" required="please"></td></br></br>
			</tr>
			<tr>
				<td><input type="password" placeholder="Password" name="password" value="" id="Show" required><label>Show Password</label></td>
            </tr>
				<tr>
				<td><input type="checkbox" placeholder="" name="" onclick="myFunction()" value="" ></td>
            </tr>
                 <a href="../view/forgotpass.php"></br></br>Forgot password?</a></br></br>


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
				</script>
				
			
			<div class="btn">
				<input type="submit" name="submit" value="Login" ></button>
			</div>
			</br>Creat new user? <a href="../view/">Signup Here</a>.
        </br></br>Signup as transport admin? <a href="../view/Signup.html">Signup Here</a>.
		
		</form>
</div>
</body>
</html>