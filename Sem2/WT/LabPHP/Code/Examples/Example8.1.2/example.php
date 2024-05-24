<!DOCTYPE HTML>
<html>
<head>
<title>Examples</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style>
    body {
        background-color: pink;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
    }
    form {
        background-color: white;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
    input[type="text"] {
        width: calc(100% - 22px);
        padding: 10px;
        margin: 10px 0;
        border: 1px solid #ccc;
        border-radius: 5px;
    }
    input[type="submit"] {
        background-color: blue;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
    }
    input[type="submit"]:hover {
        background-color: darkblue;
    }
    .output {
        color: blue;
        margin-top: 20px;
    }
    .php-output {
        color: pink;
    }
</style>
</head>
<body>
<form method="POST">
    <input type="text" name="test" placeholder="Enter text here">
    <?php if (isset($_POST['test'])) echo htmlspecialchars($_POST['test']); ?>
    <input type="submit" name="numele_butonului_submit" value="Inregistreaza">
    <div class="output">
        <?php if (!empty($_POST)) print_r($_POST); ?>
    </div>
</form>

<div class="php-output">
<?php
$serv = $_SERVER['SERVER_PROTOCOL'];
echo "\nURI folosit pentru accesul la pagina curenta: <b>$serv</b>";

$serv = $_SERVER['REQUEST_URI'];
echo "<p>Numele si versiunea protocolului prin intermediul caruia s-a executat cererea: <b>$serv</b></p>";
?>
</div>

</body>
</html>
