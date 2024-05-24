<?php
//the code sets a cookie that count how many times the file was executed based on a request from the
//user's PC
date_default_timezone_set('UTC');
if (isset($_COOKIE['incercare'])) setcookie("incercare", $_COOKIE['incercare']+1, time()+36000);
else setcookie("incercare",1,time()+36000);
foreach($_POST as $key=>$value){
  if ($value == "incercare") echo $value. " ". $_COOKIE['incercare']." ". date("m.d.y");
  else echo $value. " ".date("m.d.y")." ";
}
The result is:
?>
