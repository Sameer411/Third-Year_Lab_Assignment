function registration()
{
	var name=document.getElementById("n").value;
	var email=document.getElementById("e").value;
	var address=document.getElementById("a").value;
	var contact=document.getElementById("c").value;
	var dob=document.getElementById("b").value;

	//var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
	var letters = /^[A-Za-z]+$/;
	var numbers = /^\d{10}$/;

	if(name=="")
	{
		document.getElementById("nerr").innerHTML="*Name Field is Empty";
		return false;
	}
	else if(!letters.test(name))
	{
		document.getElementById("nerr").innerHTML="Name Field require only alphabets";
		return false;
	}
	else if(letters.test(name))
	{
		document.getElementById("nerr").innerHTML="";
		//return false;
	}

  	if(email=="")
	{
		document.getElementById("eerr").innerHTML="*E-mail Field is Empty";
		return false;
	}
	else if(!mailformat.test(email))
	{
		document.getElementById("eerr").innerHTML="Enter a valid email Id";
		return false;
	}
	else if(mailformat.test(email))
	{
		document.getElementById("eerr").innerHTML="";
		//return true;
	}

	if(contact=="")
	{
		document.getElementById("cerr").innerHTML="*Contact Field is Empty";
		return false;
	}
	else if(!numbers.test(contact))
	{
		document.getElementById("cerr").innerHTML="Enter a vaild Phone number";
		return false;
	}

	else if(numbers.test(contact))
	{
		document.getElementById("cerr").innerHTML="";
		//return false;
	}
	 if(address=="")
	{
		document.getElementById("aerr").innerHTML="*Address Field is Empty";
		return false;
	}
	else if(address!="")
	{
		document.getElementById("aerr").innerHTML="";	
		
	}

	
	
	
	else
	{				                            
        	//alert('Thank You for Registration');
		return true;
			   // Redirecting to other page or webste code. 
			   //window.location = "http://www.campuslife.co.in"; 
	}

	
	
}

