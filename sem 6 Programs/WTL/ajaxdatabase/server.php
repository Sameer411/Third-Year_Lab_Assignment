<?php 
  $conn = mysqli_connect('localhost', 'root', '', 'ajax');
  if (!$conn) {
    die('Connection failed ' . mysqli_error($conn));
  }

   
  if (isset($_POST['save'])) {
    $name = $_POST['name'];
  	$address = $_POST['address'];
	$dept = $_POST['dept'];
  	$sql = "INSERT INTO comments (name, address,dept) VALUES ('{$name}', '{$address}', '{$dept}')";
  	if (mysqli_query($conn, $sql)) {
  	  $id = mysqli_insert_id($conn);
      $saved_comment = '<div class="comment_box">
      		<span class="delete" data-id="' . $id . '" >delete</span>
      		<span class="edit" data-id="' . $id . '">edit</span>
      		<div class="display_name">Name : '. $name .'</div>
      		<div class="comment_text">Address : '. $address .'</div>
			<div class="dept_text">Department : '. $dept .'</div>
      	</div>';
  	  echo $saved_comment;
  	}else {
  	  echo "Error: ". mysqli_error($conn);
  	}
  	exit();
  }
  // delete comment fromd database
  if (isset($_GET['delete'])) {
  	$id = $_GET['id'];
  	$sql = "DELETE FROM comments WHERE id=" . $id;
  	mysqli_query($conn, $sql);
  	exit();
  }
  if (isset($_POST['update'])) {
  	$id = $_POST['id'];
  	$name = $_POST['name'];
  	$address = $_POST['address'];
	$dept = $_POST['dept'];
  	$sql = "UPDATE comments SET name='{$name}', address='{$address}', dept='{$dept}' WHERE id=".$id;
  	if (mysqli_query($conn, $sql)) {
  		$id = mysqli_insert_id($conn);
  		$saved_comment = '<div class="comment_box">
  		  <span class="delete" data-id="' . $id . '" >delete</span>
  		  <span class="edit" data-id="' . $id . '">edit</span>
  		  <div class="display_name">'. $name .'</div>
  		  <div class="comment_text">'. $address .'</div>
		  <div class="dept_text">'. $dept .'</div>
  	  </div>';
  	  echo $saved_comment;
  	}else {
  	  echo "Error: ". mysqli_error($conn);
  	}
  	exit();
  }

  // Retrieve comments from database
  $sql = "SELECT * FROM comments";
  $result = mysqli_query($conn, $sql);
  $addresss = '<div id="display_area">'; 
  while ($row = mysqli_fetch_array($result)) {
  	$addresss .= '<div class="comment_box">
  		  <span class="delete" data-id="' . $row['id'] . '" >delete</span>
  		  <span class="edit" data-id="' . $row['id'] . '">edit</span>
  		  <div class="display_name">'. $row['name'] .'</div>
  		  <div class="comment_text">'. $row['address'] .'</div>
		  <div class="dept_text">'. $row['dept'] .'</div>
  	  </div>';
  }
  $addresss .= '</div>';
?>