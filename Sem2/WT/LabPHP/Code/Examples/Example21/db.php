<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<?php
//Mysqli Documentation on Php Manual web page
//https://www.php.net/manual/en/class.mysqli.php
class connect{
    public $host;//localhost
    public $username;//root
    public $password;//""
    public $db;//"tipuri"
    public $con;
    function connect($host,$username,$password,$db)
    {
        $this->host=$host;
        $this->username=$username;
        $this->password=$password;
        $this->db=$db;
    }
    function connection(){
        $this->con = new mysqli($this->host,$this->username,$this->password,$this->db);
        if  (!$this->con->connect_errno)
            {echo "connection established.<br>";}
        else {header('Location: http://www.utcluj.ro/');//echo "connection failed<br>";
        //else {header('Location: exemplu 4.php');//echo "connection failed<br>";
        exit();
        }

    }
    function commitSomething(){
        try{
            // Turn autocommit off
            $this->con->autocommit(False);
            // Insert some values
            $this->con->query("INSERT INTO HumanResources (FirstName,LastName,Income)   VALUES ('zuzu1','bubu1',12345)");
            $this->con->query("INSERT INTO HumanResources (FirstName,LastName)  VALUES ('zuzu2','bubu2',1234567)");
            $this->con->commit();
            echo "Commit transaction finished";
        }
        catch (Exception $e)
        {if ($e->getMessage()<>'') header('Location: exemplu 4.php');exit();}//start/stop server myslq to see the effects
    }
    function fetchSomething($sql){
        //$sql = "SELECT LastName, Income FROM HumanResources  ORDER BY Income";
        //interogarea
        $result = $this->con-> query($sql);
        // Numeric array
        $row = $result -> fetch_array(MYSQLI_NUM);
        printf ("<br>%s (%s)\n", $row[0], $row[1]);
        echo "<br>";
        // Associative array
        $row = $result -> fetch_array(MYSQLI_ASSOC);
        printf ("%s (%s)\n", $row["LastName"], $row["Income"]);
        echo "<br>";
        // Free result set
        $result -> free_result();

    }
    function fetchFieldInfo($sql){
        //$sql = "SELECT LastName, Income FROM HumanResources  ORDER BY Income";
            //interogarea
        if ($result = $this->con-> query($sql)) {
            // Get field information for all fields
            while ($fieldinfo = $result -> fetch_field()) {
                printf("Name: %s\t", $fieldinfo -> name);
                printf("Table: %s\t", $fieldinfo -> table);
                printf("Max. Len: %d<br>", $fieldinfo -> max_length);
            }
        }
        $result -> free_result();
    }
    function selectPopulareFiltru($sql){
        $result = $this->con->query($sql);
        $i=0;
        //exemplificare extragere info cap de tabel
        while ($fieldinfo = $result -> fetch_field()) {

                    $name[$i]= $fieldinfo -> name;
                    echo $name[$i]." ";
                    $i++;
        }
        echo "<br>";
        if ($result->num_rows > 0) {
            $initial=$result->fetch_assoc();
            echo "<select id='type and stoc'>   ";
            while($row = $result->fetch_assoc()) {

                    for ($i=0;$i<sizeof($name);$i++)
                    // echo "<option value=".$row[$name[$i]].">". $row[$name[$i]]."</option>";
                    if ($name[$i]=="type") echo "<option value=".$row["type"].">". $row["type"]." stoc= ". $row["stoc"]. "</option>";
                echo "<br>";
                }
            echo "</select> ";
        } else {
            echo "0 results";
        }
        $result -> free_result();
    }
    function selectPopulareFiltru2($sql){
        $result = $this->con->query($sql);
        $i=0;
        echo "<br> Campurile disponibile in baza de date sunt: <br>";
        while ($fieldinfo = $result -> fetch_field()) {
                    $name[$i]= $fieldinfo -> name;
                    echo $name[$i]." ";
                    $i++;
        }
        echo "<br><hr>";
        echo "Exemplificare populare optiuni campuri select in functie de valoarea extrasa din baza de date: <br>";
        if ($result->num_rows > 0)
//atentie la valoarea initiala a lui $i deoarece aplic un data_seek($i-1)
                for ($i=0;$i<sizeof($name);$i++){
                    $result ->data_seek($i-1);
                    echo "<select id=".$name[$i]."> ";
                    while($row = $result->fetch_assoc()) {
                            echo "<option value=".$row[$name[$i]].">". $row[$name[$i]]."</option>";
                            echo "<br>";
                    }
                    echo "</select> ";
            }

        else {
            echo "0 results";
        }
        $result -> free_result();
    }
    function selectSomething($sql){
        try{

        $result = $this->con->query($sql);
        $i=0;
        while ($fieldinfo = $result -> fetch_field()) {

                    $name[$i]= $fieldinfo -> name;
                    echo $name[$i];
                    $i++;
        }
        echo "<br>";
        if ($result->num_rows > 0) {
            while($row = $result->fetch_assoc()) {
                    for ($i=0;$i<sizeof($name);$i++)
                    echo $row[$name[$i]]." ";
                echo "<br>";
                }
        } else {
            echo "0 results";
        }
        $result -> free_result();
        }catch(Exception $e){
            header("'Refresh: 1; Location:http://localhost/Error_page.html");

        }
    }
}

    $objectConnect=new Connect("localhost","root","","test");
    $objectConnect->connection();
    $sql="SELECT id, type,stoc FROM tipuri";?>
    <div  id=format1">
    <?php
    //selectare cu populare select
    $objectConnect->selectPopulareFiltru($sql);?>
    </div>
    <div  id=format1">
    <?php
    //selectare cu populare multiplu select
    $objectConnect->selectPopulareFiltru2($sql);?>
    </div> <div  id=format1">
    <?php
    //selectare fara populare select
    $objectConnect->selectSomething($sql);?>
    </div>
    <?php
    //$sql="SELECT * FROM tipuri";
    //$objectConnect->selectSomething($sql);
    $objectConnect->con->close();
?>
