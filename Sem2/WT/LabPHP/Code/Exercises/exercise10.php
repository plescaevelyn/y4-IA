<!DOCTYPE HTML>
<html>
<head>
    <title>Enter Personal Data</title>
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
    </style>
</head>
<body>
    <form method="POST" action="exercise10_process.php">
        <label for="first_name">First Name:</label>
        <input type="text" name="first_name" id="first_name" required>

        <label for="last_name">Last Name:</label>
        <input type="text" name="last_name" id="last_name" required>

        <label for="father_name">Father's Name:</label>
        <input type="text" name="father_name" id="father_name" required>

        <label for="mother_name">Mother's Name:</label>
        <input type="text" name="mother_name" id="mother_name" required>

        <label for="cnp">CNP:</label>
        <input type="text" name="cnp" id="cnp" required>

        <label for="id_series">ID Series:</label>
        <input type="text" name="id_series" id="id_series" required>

        <label for="id_number">ID Number:</label>
        <input type="text" name="id_number" id="id_number" required>

        <label for="date_of_birth">Date of Birth:</label>
        <input type="date" name="date_of_birth" id="date_of_birth" required>

        <label for="address">Address:</label>
        <input type="text" name="address" id="address" required>

        <label for="married">Married:</label>
        <select name="married" id="married" required>
            <option value="yes">Yes</option>
            <option value="no">No</option>
        </select>

        <label for="children">Children:</label>
        <input type="number" name="children" id="children" min="0" required>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
