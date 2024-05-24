<!DOCTYPE HTML>
<html>
<head>
<title>Calculator</title>
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
    input[type="number"] {
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
    <label for="num1">Enter first number:</label>
    <input type="number" name="num1" id="num1" required>
    <label for="num2">Enter second number:</label>
    <input type="number" name="num2" id="num2" required>
    <input type="submit" name="calculate" value="Calculate">
</form>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $num1 = $_POST['num1'];
    $num2 = $_POST['num2'];

    if (is_numeric($num1) && is_numeric($num2)) {
        $sum = $num1 + $num2;
        $difference = $num1 - $num2;
        $product = $num1 * $num2;
        if ($num2 != 0) {
            $division = $num1 / $num2;
        } else {
            $division = "undefined (division by zero)";
        }

        echo "<div class='output'>";
        echo "<p>Sum: $sum</p>";
        echo "<p>Difference: $difference</p>";
        echo "<p>Product: $product</p>";
        echo "<p>Division: $division</p>";
        echo "</div>";
    } else {
        echo "<div class='output'><p>Please enter valid numbers.</p></div>";
    }
}
?>
</body>
</html>
