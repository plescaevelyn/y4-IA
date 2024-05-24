<html>
<head>
<title>Response page:</title>
</head>
<body>
The received variable values are:<br>
<?php
 foreach ($_POST as $key => $temp)
  echo $key." = ".$temp."<br>";
?>
<body>
<html>
