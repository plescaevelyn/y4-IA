<!DOCTYPE HTML>
<html>
<head>
    <title>Processing Salary Data</title>
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
            color: #d147a3;
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
    <div class="container">
        <?php
        $servername = "localhost";
        $username = "root";
        $password = "";
        $dbname = "staff";

        // Create connection
        $conn = new mysqli($servername, $username, $password, $dbname);

        // Check connection
        if ($conn->connect_error) {
            die("<div class='output'><p>Connection failed: " . $conn->connect_error . "</p></div>");
        }

        if ($_SERVER["REQUEST_METHOD"] == "POST") {
            $cnp = $_POST['cnp'];
            $net_salary = $_POST['net_salary'];
            $gross_salary = $_POST['gross_salary'];
            $tax_amount = $_POST['tax_amount'];
            $payment_date = $_POST['payment_date'];
            $start_date = $_POST['start_date'];
            $end_date = isset($_POST['end_date']) ? $_POST['end_date'] : NULL;
            $increase_reason = $_POST['increase_reason'];

            // Handle NULL end_date
            if ($end_date) {
                $end_date = "'$end_date'";
            } else {
                $end_date = "NULL";
            }

            $sql = "INSERT INTO salaries (cnp, net_salary, gross_salary, tax_amount, payment_date, start_date, end_date, increase_reason)
                    VALUES ('$cnp', '$net_salary', '$gross_salary', '$tax_amount', '$payment_date', '$start_date', $end_date, '$increase_reason')";

            if ($conn->query($sql) === TRUE) {
                echo "<div class='output'><p>Record added successfully</p></div>";
            } else {
                echo "<div class='output'><p>Error: " . $sql . "<br>" . $conn->error . "</p></div>";
            }
        }

        $conn->close();
        ?>
        <div class='output'>
            <p><a href="exercise12.php">Go back to the form</a></p>
        </div>
    </div>
</body>
</html>
