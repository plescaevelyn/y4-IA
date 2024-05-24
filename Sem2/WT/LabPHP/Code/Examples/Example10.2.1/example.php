<!DOCTYPE html>
<html>
<head>
    <title>PHP Example</title>
    <meta charset="UTF-8">
</head>
<body>
    <pre>
<?php
$ex1 = TRUE;
$ex2 = FALSE;
$ex3 = (string) $ex1;
$ex4 = (string) $ex2;
$ex5 = 1.17e2;
$ex6 = (string) $ex5;
$ex7 = array("a" => "1", 2 => 17);
$ex8 = (string) json_encode($ex7);

echo "The truth value TRUE equals the string $ex3\n";
echo "The truth value FALSE equals the string $ex4\n";
echo "Float value $ex5 equals string \"$ex6\"\n";
echo "By converting an array having as elements {$ex7['a']} and {$ex7[2]} to string, the value obtained is \"$ex8\"";
?>
    </pre>
</body>
</html>
