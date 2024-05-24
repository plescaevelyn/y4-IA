<?php

try {$con = new mysqli("localhost","root","","wt");

    echo "connection established.<br>";
    $request="INSERT INTO personaje values ('$_POST[Nume]','$_POST[Puteri]','$_POST[Varsta]')"; // pregatim cererea
    $result=$con->query($request); // executam cererea
    echo "The data is inserted.";
}

catch(Exception $e) {
    {echo  'Message: ' .$e->getMessage(); header('Location: http://www.utcluj.ro/');//echo "connection failed<br>";
//else {header('Location: exemplu 4.php');//echo "connection failed<br>";
exit();
}
}
