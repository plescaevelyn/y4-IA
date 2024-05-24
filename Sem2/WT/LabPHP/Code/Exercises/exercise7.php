<!DOCTYPE HTML>
<html>
<head>
<title>Identify User</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style>
    body {
        background-color: pink;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        color: #d147a3;=
    }
    .container {
        background-color: #ffd1dc;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    }
</style>
</head>
<body>
<div class="container">
    <?php
    $cookie_name = "user";
    $cookie_value = "identified_user";
    $cookie_lifetime = time() + (86400 * 30);

    if (!isset($_COOKIE[$cookie_name])) {
        setcookie($cookie_name, $cookie_value, $cookie_lifetime, "/");
        echo "<p>Welcome, new user! A cookie has been set to identify you on your next visit.</p>";
    } else {
        echo "<p>Welcome back, identified user! You are recognized by the cookie.</p>";
    }
    ?>
</div>
</body>
</html>
