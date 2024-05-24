<?php

function apiRestCall()
{
    //$city=$_POST["city"];
    $city="Turda";
    // create & initialize a curl session
    $curl = curl_init();
    // set our url with curl_setopt()
    curl_setopt($curl, CURLOPT_URL, "http://api.openweathermap.org/data/2.5/weather?q=".$city."&appid=58819c0556b08d963882c7c8a8c98041");
    curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
    curl_setopt($curl, CURLOPT_POST, true);
    $output = curl_exec($curl);
    if ($output === false) {
        $info = curl_getinfo($curl);
        curl_close($curl);
        die('error occured during curl exec. Additioanl info: ' . var_export($info));
    }
    curl_close($curl);
    $decoded = json_decode($output,true);
    if (isset($decoded->response->status) && $decoded->response->status == 'ERROR') {
        die('error occured: ' . $decoded->response->errormessage);
    }
    echo 'response ok!<br>';
    print_r($decoded);
    //obiectul returnat este un array associativ
    return $decoded;
}
apiRestCall();
?>
