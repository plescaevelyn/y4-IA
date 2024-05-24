<!DOCTYPE HTML>
<html>
<head>
    <title>Enter Salary Data</title>
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
        input, select {
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
        a {
            color: #d147a3;
            text-decoration: none;
        }
        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <form method="POST" action="exercise12_process.php">
        <label for="cnp">CNP:</label>
        <input type="text" name="cnp" id="cnp" required>

        <label for="net_salary">Net Salary:</label>
        <input type="number" step="0.01" name="net_salary" id="net_salary" required>

        <label for="gross_salary">Gross Salary:</label>
        <input type="number" step="0.01" name="gross_salary" id="gross_salary" required>

        <label for="tax_amount">Tax Amount:</label>
        <input type="number" step="0.01" name="tax_amount" id="tax_amount" required>

        <label for="last_increase_date">Date of Last Increase:</label>
        <input type="date" name="last_increase_date" id="last_increase_date" required>

        <label for="increase_reason">Reason for Increase:</label>
        <input type="text" name="increase_reason" id="increase_reason" required>

        <label for="start_date">Start Date of Employment:</label>
        <input type="date" name="start_date" id="start_date" required>

        <label for="end_date">End Date of Employment (if applicable):</label>
        <input type="date" name="end_date" id="end_date">

        <input type="submit" value="Submit">
    </form>
</body>
</html>
