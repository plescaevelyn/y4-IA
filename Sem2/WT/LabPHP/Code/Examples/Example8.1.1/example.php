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
    .php-output {
        color: #d147a3;
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
