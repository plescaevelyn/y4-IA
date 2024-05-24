<html>
<head>
<title>Characters data </title>
</head>
<body>
<?php
//We connect to the specified server
//In account you specified

try {$con = new mysqli("localhost","root","","wt");

    echo "connection established.<br>";
    $request="SELECT * from personaje"; // pregatim cererea
    $result=$con->query($request); // executam cererea
    while($row = $result -> fetch_array(MYSQLI_ASSOC))
        {
            printf ("%s (%s)\n", $row["nume"], $row["puteri"]);
            echo "<br>";
        }
    // Free result set
    $result -> free_result();
}

catch(Exception $e) {
    {echo  'Message: ' .$e->getMessage(); header('Location: http://www.utcluj.ro/');//echo "connection failed<br>";
//else {header('Location: exemplu 4.php');//echo "connection failed<br>";
exit();
}
}

?>
</body>
</html>
