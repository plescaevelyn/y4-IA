<?php
function  referinta(&$var) {
                 $var=3;
     }
     $ex = 0;
     referinta($ex);
     echo ”The result is $ex”;    // the result is  3
?>
