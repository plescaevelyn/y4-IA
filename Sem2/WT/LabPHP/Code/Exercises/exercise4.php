<!DOCTYPE HTML>
<html>
<head>
<title>String Comparison</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style>
    body {
        background-color: pink;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        color: #d147a3;
    }
    form {
        background-color: #ffd1dc;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        color: #d147a3;
    }
    input[type="text"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #d147a3;
        border-radius: 5px;
        color: #d147a3;
    }
    input[type="submit"] {
        background-color: #d147a3;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #b0368a;
    }
    .output {
        color: #d147a3;
        margin-top: 20px;
    }
</style>
</head>
<body>
<form method="POST">
    <label for="string1">Enter first string:</label>
    <input type="text" name="string1" id="string1" required>
    <label for="string2">Enter second string:</label>
    <input type="text" name="string2" id="string2" required>
    <input type="submit" name="compare" value="Compare">
</form>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $string1 = $_POST['string1'];
    $string2 = $_POST['string2'];

    $strings = [$string1, $string2];
    sort($strings);

    echo "<div class='output'>";
    echo "<p>Strings in ascending order:</p>";
    echo "<p>$strings[0]</p>";
    echo "<p>$strings[1]</p>";
    echo "</div>";
}
?>
</body>
</html>
