<!DOCTYPE HTML>
<html>
<head>
    <title>Select Men Born After 1970</title>
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
        <h2>Men Born After 1970</h2>
        <?php
        $servername = "localhost";
        $username = "root";
        $password = "";
        $dbname = "staff";

        $conn = new mysqli($servername, $username, $password, $dbname);

        if ($conn->connect_error) {
            die("<div class='output'><p>Connection failed: " . $conn->connect_error . "</p></div>");
        }

        $sql = "SELECT * FROM date_personale WHERE date_of_birth > '1970-01-01'";
        $result = $conn->query($sql);

        if ($result->num_rows > 0) {
            $num_records = $result->num_rows;
            echo "<div class='output'><p>Number of men born after 1970: $num_records</p></div>";

            echo "<div class='output'><table border='1'>
                    <tr>
                        <th>CNP</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Father's Name</th>
                        <th>Mother's Name</th>
                        <th>ID Series</th>
                        <th>ID Number</th>
                        <th>Date of Birth</th>
                        <th>Address</th>
                        <th>Married</th>
                        <th>Children</th>
                    </tr>";

            while ($row = $result->fetch_assoc()) {
                echo "<tr>
                        <td>" . $row["cnp"] . "</td>
                        <td>" . $row["first_name"] . "</td>
                        <td>" . $row["last_name"] . "</td>
                        <td>" . $row["father_name"] . "</td>
                        <td>" . $row["mother_name"] . "</td>
                        <td>" . $row["id_series"] . "</td>
                        <td>" . $row["id_number"] . "</td>
                        <td>" . $row["date_of_birth"] . "</td>
                        <td>" . $row["address"] . "</td>
                        <td>" . $row["married"] . "</td>
                        <td>" . $row["children"] . "</td>
                    </tr>";
            }
            echo "</table></div>";
        } else {
            echo "<div class='output'><p>No records found.</p></div>";
        }

        $conn->close();
        ?>
        <div class='output'>
            <p><a href="exercise10.php">Go back to the form</a></p>
        </div>
    </div>
</body>
</html>
