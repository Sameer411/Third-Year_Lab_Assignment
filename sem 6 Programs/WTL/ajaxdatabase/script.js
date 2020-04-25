$(document).ready(function(){
  // save comment to database
  $(document).on('click', '#submit_btn', function(){
    var name = $('#name').val();
    var address = $('#address').val();
	var dept = $('#dept').val();
    $.ajax({
      url: 'server.php',
      type: 'POST',
      data: {
        'save': 1,
        'name': name,
        'address': address,
		'dept': dept,
      },
      success: function(response){
        $('#name').val('');
        $('#address').val('');
		$('#dept').val('');
        $('#display_area').append(response);
      }
    });
  });
  // delete from database
  $(document).on('click', '.delete', function(){
  	var id = $(this).data('id');
  	$clicked_btn = $(this);
  	$.ajax({
  	  url: 'server.php',
  	  type: 'GET',
  	  data: {
    	'delete': 1,
    	'id': id,
      },
      success: function(response){
        // remove the deleted comment
        $clicked_btn.parent().remove();
        $('#name').val('');
        $('#address').val('');
		$('#dept').val('');
      }
  	});
  });
  var edit_id;
  var $edit_comment;
  $(document).on('click', '.edit', function(){
  	edit_id = $(this).data('id');
  	$edit_comment = $(this).parent();
  	// grab the comment to be editted
  	var name = $(this).siblings('.display_name').text();
  	var address = $(this).siblings('.comment_text').text();
	var dept = $(this).siblings('.dept_text').text();
  	// place comment in form
  	$('#name').val(name);
  	$('#address').val(address);
	$('#dept').val(dept);
  	$('#submit_btn').hide();
  	$('#update_btn').show();
  });
  $(document).on('click', '#update_btn', function(){
  	var id = edit_id;
  	var name = $('#name').val();
  	var address = $('#address').val();
	var dept = $('#dept').val();
  	$.ajax({
      url: 'server.php',
      type: 'POST',
      data: {
      	'update': 1,
      	'id': id,
      	'name': name,
      	'address': address,
		'dept':dept,
      },
      success: function(response){
      	$('#name').val('');
      	$('#address').val('');
		$('#dept').val('');
      	$('#submit_btn').show();
      	$('#update_btn').hide();
      	$edit_comment.replaceWith(response);
      }
  	});		
  });
});
