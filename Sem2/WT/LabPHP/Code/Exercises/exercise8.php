<!DOCTYPE HTML>
<html>
<head>
<title>Error Levels</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
<style>
    body {
        background-color: pink;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 20px;
        color: #d147a3;
    }
    .container {
        background-color: #ffd1dc;
        padding: 20px;
        border-radius: 5px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
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

<div class="container">
<h2>Error Levels</h2>
<table>
    <thead>
        <tr>
            <th>Error Level</th>
            <th>Description</th>
        </tr>
    </thead>
    <tbody>
        <?php
        $error_levels = [
            E_ERROR => 'Fatal run-time errors',
            E_WARNING => 'Run-time warnings (non-fatal errors)',
            E_PARSE => 'Compile-time parse errors',
            E_NOTICE => 'Run-time notices',
            E_CORE_ERROR => 'Fatal errors that occur during PHP\'s initial startup',
            E_CORE_WARNING => 'Warnings that occur during PHP\'s initial startup',
            E_COMPILE_ERROR => 'Fatal compile-time errors',
            E_COMPILE_WARNING => 'Compile-time warnings',
            E_USER_ERROR => 'User-generated error message',
            E_USER_WARNING => 'User-generated warning message',
            E_USER_NOTICE => 'User-generated notice message',
            E_STRICT => 'Enable to have PHP suggest changes to your code',
            E_RECOVERABLE_ERROR => 'Catchable fatal error',
            E_DEPRECATED => 'Run-time notices about deprecated code',
            E_USER_DEPRECATED => 'User-generated warning about deprecated code'
        ];

        foreach ($error_levels as $level => $description) {
            echo "<tr><td>$level</td><td>$description</td></tr>";
        }
        ?>
    </tbody>
</table>
</div>

</body>
</html>
