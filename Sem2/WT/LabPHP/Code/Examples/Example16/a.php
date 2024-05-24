<?php
session_start();//startează o sesiune de lucru
$_SESSION['a']="prima pagina";//Assigns a string to the variable
echo '<br /><a href="b.php">the link for the next page </a>';
echo $_SESSION['b']; //Prints the value of variable B set on the previous page
?>
