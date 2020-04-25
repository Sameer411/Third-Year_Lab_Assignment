<?php
$mysqli = new mysqli("localhost", "root", "", "phdatabase");
 

if($mysqli === false){
    die("ERROR: Could not connect. " . $mysqli->connect_error);
}
 
$name = $mysqli->real_escape_string($_REQUEST['name']);

$age = $mysqli->real_escape_string($_REQUEST['age']);
$phoneno = $mysqli->real_escape_string($_REQUEST['phoneno']);

$email= $mysqli->real_escape_string($_REQUEST['email']);


$sql="UPDATE stud set age='$age' where name='$name'";
if($mysqli->query($sql) === true)
{
	echo "Records updated successfully ";
}
else
{
	echo "Records not updated successfully $sql." .$mysqli->error;
}
$mysqli->close();


?>