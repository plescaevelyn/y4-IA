<!DOCTYPE HTML>
<html>
<head>
<title>Remove White Spaces</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style>
    body {
        background-color: pink;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        color: #d147a3; /* Dark pink text */
    }
    form {
        background-color: #ffd1dc; /* Light pink form background */
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        color: #d147a3; /* Dark pink text */
    }
    input[type="text"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #d147a3; /* Dark pink border */
        border-radius: 5px;
        color: #d147a3; /* Dark pink text */
    }
    input[type="submit"] {
        background-color: #d147a3; /* Dark pink button */
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: #b0368a; /* Darker pink on hover */
    }
    .output {
        color: #d147a3; /* Dark pink text */
        margin-top: 20px;
    }
</style>
</head>
<body>
<form method="POST">
    <label for="word">Enter a word:</label>
    <input type="text" name="word" id="word" required>
    <input type="submit" name="submit" value="Submit">
</form>

<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    $word = $_POST['word'];
    $trimmedWord = str_replace(' ', '', $word);

    if (empty($trimmedWord)) {
        echo "<div class='output'><p>The string is empty after removing white spaces. Please enter another string.</p></div>";
    } else {
        echo "<div class='output'><p>The string without white spaces is: $trimmedWord</p></div>";
    }
}
?>
</body>
</html>
