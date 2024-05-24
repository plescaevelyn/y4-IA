<?php
$fisu=fopen("log.txt","a+");
echo "Conectare cu <strong>".$_SERVER["HTTP_USER_AGENT"]."</strong> de la <strong>".$_SERVER["REMOTE_ADDR"]."</strong> la data de <strong>".date("l dS F Y h:i:s A")."</strong>.";

fwrite($fisu,"Conectare cu ".$_SERVER["HTTP_USER_AGENT"]." de la ".$_SERVER["REMOTE_ADDR"]." la data de ".date("l dS of F Y h:i:s A").".\n");
