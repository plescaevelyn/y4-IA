<!DOCTYPE HTML>
<html>
<head>
<title>Server Information</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style>
    body {
        background-color: pink;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        color: #d147a3;
    }
    .server-info {
        background-color: #ffd1dc;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        color: #d147a3;
    }
    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
    }
    th, td {
        border: 1px solid #d147a3;
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: #d147a3;
        color: white;
    }
</style>
</head>
<body>

<div class="server-info">
<h2>Server Information</h2>
<table>
    <thead>
        <tr>
            <th>Variable</th>
            <th>Value</th>
        </tr>
    </thead>
    <tbody>
        <?php
        foreach ($_SERVER as $key => $value) {
            echo "<tr><td>$key</td><td>$value</td></tr>";
        }
        ?>
    </tbody>
</table>
</div>

</body>
</html>
