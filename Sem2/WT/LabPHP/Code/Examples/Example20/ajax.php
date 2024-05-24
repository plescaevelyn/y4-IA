<?php
date_default_timezone_set('UTC');
foreach($_POST as $key=>$value){
   echo $value. "<hr width='50%' style='margin-right:100%;border:0px; border-top: 6px solid green;  border-radius: 2px;'> ";
}
echo "Values submitted today:". date("m.d.y").".<br>";
?>
The result is:
