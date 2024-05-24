<?php
session_start();
$_SESSION['b']= "second page";
echo '<br /><a href="a.php"> Link to previous page </a> ';
echo $_SESSION['a'];
?>
