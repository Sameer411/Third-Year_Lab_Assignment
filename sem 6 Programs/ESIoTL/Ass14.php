#Assignment No.:14
#Problem Statement : Create a simple web interface for raspberry-pi/Beagle board to control the connected #LEDs
#remotely through the interface.
#Name :Sameer Rathod
#TE B 58 



<html>
<head>
	<title> LED CONTROL</title>
</head>
<body>
<h1 align=”center”> CONTROL YOUR LED </h1>
<form method=”POST”>
	<table align=”center”>
		<tr align=”center”>
			<th align=”center”><input type=”submit” name=”on” value=”ON”</th>
<th align=”center”><input type=”submit” name=”off” value=”OFF”</th>
		</tr>
	</table>
</form>

 <?php
if(isset($_POST[‘on’]))
{
	system(‘gpio write 1 1’);
}
if(isset($_POST[‘off’]))
{
	system(‘gpio write 1 0’);
}
?>

</body>
</html>
