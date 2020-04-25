<?php
$mysqli = new mysqli("localhost", "root", "", "phdatabase");
 

if($mysqli === false){
    die("ERROR: Could not connect. " . $mysqli->connect_error);
}
 
$name = $mysqli->real_escape_string($_REQUEST['name']);

$age = $mysqli->real_escape_string($_REQUEST['age']);
$phoneno = $mysqli->real_escape_string($_REQUEST['phoneno']);

$email= $mysqli->real_escape_string($_REQUEST['email']);


/*$sql="SELECT * from stud";
$result = mysqli_query($mysqli, $sql);
$row = mysqli_fetch_array($mysqli_result);

while ($row = mysqli_fetch_array(MYSQLI_NUM)) {
 echo $row['name'] . ' ' . $row['age'] . ' ' . $row['phoneno'] .' '. $row['email'] .'<br />';
}*/
/*if($mysqli->query($sql) === true)
{
	echo "Records displayed successfully successfully ";
	echo "$sql['name'] . ' ' . $sql['age'] . ' '.$sql['phoneno'] .' '.$sql[email] ";
}
else
{
	echo "Records not displayed successfully $sql." .$mysqli->error;
}*/
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
         //mysqli_close($mysqli);
$mysqli->close();


?>