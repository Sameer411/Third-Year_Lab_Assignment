<?php
//calculate length of string
$str1="PHP is Fun";
$length=strlen($str1);
echo "<b> Length:</b>Length of string is:$str1 is =$length ";
//find the position of a word in string

echo "<br/> <b> Position : </b> The position of word Fun in the string $str1 is " .strpos($str1,'Fun');

//comparison of two strings

$str1="Hello";
$str2="hello";
if(strcmp($str1,$str2))
	echo "<br/> <b> Comparison : </b> The two strings $str1 and $str2 are not equal ";
else
		echo "<br/> <b> Comparison : </b> The two strings $str1 and $str2 are equal ";

//lowercase

	$str1="HARSHA";
	echo "<br/><b>Changing case: </b> The string $str1 becomes " .strtolower($str1);

//reverse a string

	echo "</br><b> Reversing string: </b>The string $str1 is reversed as " .strrev($str1);


//Concatenating two strings

	$str1="Harsha";
	$str2="Gondhalekar";

	echo "</br><b>Concatenating strings:</b> The string $str1 and $str2 are concatenated as ".$str1.$str2;

//Replacing all the instances of string

	echo "</br><b>Replacing all instances of string : </b> The string tictactoe is now ";
	echo str_replace("t","p","tictactoe");

//Replacing substring 

	$str1="world";
	$newstring=substr_replace("world","petter","Hello world");
	echo "<br> <b> Replacing substring : </b> $str1 becomes $newstring ";
?>