<?php
$mysqli = new mysqli("localhost", "root", "", "phdatabase");
 

if($mysqli === false){
    die("ERROR: Could not connect. " . $mysqli->connect_error);
}
 
$name = $mysqli->real_escape_string($_REQUEST['name']);

$age = $mysqli->real_escape_string($_REQUEST['age']);
$phoneno = $mysqli->real_escape_string($_REQUEST['phoneno']);

$email= $mysqli->real_escape_string($_REQUEST['email']);


$sql="INSERT INTO stud(name,age,phoneno,email) VALUES ('$name','$age','$phoneno','$email')";
if($mysqli->query($sql) === true)
{
	echo "Records inserted successfully \n ";
}
else
{
	echo "Records not inserted successfully $sql." .$mysqli->error;
}
$sql = 'SELECT * FROM stud';
         $result = mysqli_query($mysqli, $sql);

         if (mysqli_num_rows($result) > 0) {
            while($row = mysqli_fetch_assoc($result)) {
               echo "Name: " . $row["name"]. "<br>";
                echo "Age: " . $row["age"]. "<br>";
                 echo "Phoneno: " . $row["phoneno"]. "<br>";
                  echo "Email: " . $row["email"]. "<br>";
            }
         } else {
            echo "NO results :";
         }
$mysqli->close();


?>