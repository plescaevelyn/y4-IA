<?
$mesaj="first mail\n We are trying to send an email to the course";
$header="from:cont@mail_server_SMTP.com";
$mesaj_final=wordwrap($mesaj,70);//if lines are longer than 70 characters
mail("cont@mail2.com ","example",$mesaj_final,$header);
?>
