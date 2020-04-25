<?php include('server.php'); ?>
<!DOCTYPE html>
<html lang="en">
<head>
  <script src="jquery.min.js"></script>

  <meta charset="UTF-8">
  <title>Insert and Retrieve data from MySQL database with ajax</title>
  <link rel="stylesheet" href="styles.css">
</head>
<body>
  <div class="wrapper">
  	<?php echo $addresss; ?>
  	<form class="comment_form">
      <div>
        <label for="name">Name:</label>
      	<input type="text" name="name" id="name">
      </div>
      <div>
      	<label for="address">Address:</label>
      	<textarea name="address" id="address" cols="30" rows="5"></textarea>
      </div>
	  <div>
      	<label for="dept">Department:</label>
      	<textarea name="dept" id="dept" cols="30" rows="5"></textarea>
      </div>
      <button type="button" id="submit_btn">INSERT</button>
      <button type="button" id="update_btn" style="display: none;">UPDATE</button>
  	</form>
  </div>
</body>
</html>
<!-- Add JQuery -->
//<script src="jquery.min.js"></script>
<script src="script.js"></script>