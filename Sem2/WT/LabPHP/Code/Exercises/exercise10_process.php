<!DOCTYPE HTML>
<html>
<head>
    <title>Processing Personal Data</title>
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
            $first_name = $_POST['first_name'];
            $last_name = $_POST['last_name'];
            $father_name = $_POST['father_name'];
            $mother_name = $_POST['mother_name'];
            $cnp = $_POST['cnp'];
            $id_series = $_POST['id_series'];
            $id_number = $_POST['id_number'];
            $date_of_birth = $_POST['date_of_birth'];
            $address = $_POST['address'];
            $married_status = isset($_POST['married_status']) ? 1 : 0;
            $children = $_POST['children'];

            $sql = "INSERT INTO date_personale (cnp, first_name, last_name, father_name, mother_name, id_series, id_number, date_of_birth, address, married_status, children)
                    VALUES ('$cnp', '$first_name', '$last_name', '$father_name', '$mother_name', '$id_series', '$id_number', '$date_of_birth', '$address', '$married_status', $children)";

            if ($conn->query($sql) === TRUE) {
                echo "<div class='output'><p>Record added successfully</p></div>";
            } else {
                echo "<div class='output'><p>Error: " . $sql . "<br>" . $conn->error . "</p></div>";
            }
        }

        $conn->close();
        ?>
        <div class='output'>
            <p><a href="exercise10.php">Go back to the form</a></p>
        </div>
    </div>
</body>
</html>
