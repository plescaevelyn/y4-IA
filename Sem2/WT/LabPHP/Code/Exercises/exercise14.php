<!DOCTYPE HTML>
<html>
<head>
    <title>Weather Data</title>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
    <style>
        body {
            background-color: pink;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            color: #d147a3;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .container {
            background-color: #ffd1dc;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 300px;
            text-align: center;
        }
        .weather-icon {
            width: 100px;
            height: 100px;
        }
        .weather-info {
            margin-top: 20px;
        }
        .weather-info div {
            margin-bottom: 10px;
        }
        .location {
            font-size: 24px;
            font-weight: bold;
        }
        .temperature {
            font-size: 30px;
        }
    </style>
</head>
<body>
    <div class="container">
        <div id="weather" class="weather-info">
            <div class="location">Requesting location...</div>
        </div>
    </div>
    <script>
        async function fetchWeatherData(lat, lon) {
            const apiKey = '62070ba566346afb38545d898e7e40ff';
            const url = `https://api.openweathermap.org/data/2.5/weather?lat=${lat}&lon=${lon}&appid=${apiKey}&units=metric`;
            console.log(`Fetching weather data from: ${url}`);
            try {
                const response = await fetch(url);
                if (!response.ok) {
                    throw new Error(`HTTP error! status: ${response.status} - ${response.statusText}`);
                }
                const data = await response.json();
                console.log('Weather data fetched successfully:', data);
                displayWeatherData(data);
            } catch (error) {
                console.error('Failed to fetch weather data:', error);
                document.querySelector('.location').textContent = 'Failed to fetch weather data';
            }
        }

        function displayWeatherData(data) {
            const weatherElement = document.getElementById('weather');
            const location = data.name;
            const temperature = data.main.temp;
            const description = data.weather[0].description;
            const icon = `http://openweathermap.org/img/wn/${data.weather[0].icon}@2x.png`;

            weatherElement.innerHTML = `
                <div class="location">${location}</div>
                <img src="${icon}" alt="${description}" class="weather-icon">
                <div class="temperature">${temperature}°C</div>
                <div>${description}</div>
            `;
        }

        function getLocation() {
            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(position => {
                    const lat = position.coords.latitude;
                    const lon = position.coords.longitude;
                    console.log(`User's location: ${lat}, ${lon}`);
                    fetchWeatherData(lat, lon);
                }, error => {
                    console.error('Error getting location:', error);
                    document.querySelector('.location').textContent = 'Failed to get location';
                });
            } else {
                console.error('Geolocation is not supported by this browser.');
                document.querySelector('.location').textContent = 'Geolocation not supported';
            }
        }

        getLocation();
    </script>
</body>
</html>
