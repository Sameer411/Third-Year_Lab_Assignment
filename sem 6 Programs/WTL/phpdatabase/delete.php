<?php
$mysqli = new mysqli("localhost", "root", "", "phdatabase");
 

if($mysqli === false){
    die("ERROR: Could not connect. " . $mysqli->connect_error);
}
 
$name = $mysqli->real_escape_string($_REQUEST['name']);

$age = $mysqli->real_escape_string($_REQUEST['age']);
$phoneno = $mysqli->real_escape_string($_REQUEST['phoneno']);

$email= $mysqli->real_escape_string($_REQUEST['email']);


$sql="DELETE FROM stud where age='$age'";
if($mysqli->query($sql) === true)
{
	echo "Records deleted successfully ";
}
else
{
	echo "Records not deleted successfully $sql." .$mysqli->error;
}
$mysqli->close();


?>