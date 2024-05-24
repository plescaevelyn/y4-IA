<!DOCTYPE html>
<html>
<head>
    <title>Response page</title>
    <style>
        body {
            background-color: #ffe6f2;
            color: #ff1493;
            font-family: Arial, sans-serif;
            text-align: center;
            margin-top: 50px;
        }
    </style>
</head>
<body>
    The received value is <?php echo htmlspecialchars($_POST["val"]); ?>.
</body>
</html>
