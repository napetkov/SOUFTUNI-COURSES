function attachEvents() {
  const BASE_URL = "http://localhost:3030/jsonstore/forecaster/locations";
  const inputLocation = document.getElementById("location");
  const submitButton = document.getElementById("submit");
  const forecastContainer = document.getElementById("forecast");
  const todayForecastContainer = document.getElementById("current");
  const upcomingForecastContainer = document.getElementById("upcoming");

  
  try {
    submitButton.addEventListener("click", submitLocationHandler);
    
  async function submitLocationHandler() {
    const inputLocationName = inputLocation.value;
    const todayConditionUrl =
      "http://localhost:3030/jsonstore/forecaster/today/";
    const upcomingConditionUrl =
      "http://localhost:3030/jsonstore/forecaster/upcoming/";

    const locationRes = await fetch(BASE_URL, { method: "GET" });
    const locationData = await locationRes.json();
    let searchingLocationCode = "";
    let searchingLocationName = "";

    for (const { name, code } of locationData) {
      if (name === inputLocationName) {
        searchingLocationName = name;
        searchingLocationCode = code;
      }
    }
    inputLocation.value = "";
    forecastContainer.style.display = "block";

    fetch(`${todayConditionUrl}${searchingLocationCode}`)
      .then((res) => res.json())
      .then((data) => {
        const name = data.name;
        const forecastObj = data.forecast;
        const condition = forecastObj.condition;
        const low = forecastObj.low;
        const high = forecastObj.high;
        const todayContainer = createTodayForecastElement(
          name,
          condition,
          low,
          high
        );
        todayForecastContainer.appendChild(todayContainer);
      })
      .catch(() => {
        forecastContainer.textContent = "Error";
      });

    fetch(`${upcomingConditionUrl}${searchingLocationCode}`)
      .then((res) => res.json())
      .then((data) => {
       
        const forecastsObjs = data.forecast;
        const forecastInfoContainer = document.createElement("div");
        forecastInfoContainer.classList.add("forecast-info");

        forecastsObjs.forEach((element) => {
          forecastInfoContainer.appendChild(
            createUpcomingForecastElement(element)
          );
        });
        upcomingForecastContainer.appendChild(forecastInfoContainer);
      })
      .catch(() =>{
        forecastContainer.textContent = "Error";
      });

      todayForecastContainer.innerHTML = '';
      upcomingForecastContainer.innerHTML = '';
  
  }
} catch (error) {
    forecastContainer.textContent = "Error";
}

  function createTodayForecastElement(name, condition, low, high) {
    const container = document.createElement("div");
    container.classList.add("forecasts");
    const icon = document.createElement("span");
    switch (condition) {
      case "Sunny":
        icon.innerHTML = "&#x2600";
        break;
      case "Partly sunny":
        icon.innerHTML = "&#x26C5";
        break;
      case "Overcast":
        icon.innerHTML = "&#x2601";
        break;
      case "Rain":
        icon.innerHTML = "&#x2614";
        break;
    }
    icon.classList.add("condition", "symbol");

    const paragraphContainer = document.createElement("span");
    paragraphContainer.classList.add("condition");

    const nameParagraph = document.createElement("span");
    nameParagraph.classList.add("forecast-data");
    nameParagraph.textContent = name;

    const lowHighParagraph = document.createElement("span");
    lowHighParagraph.classList.add("forecast-data");
    lowHighParagraph.innerHTML = `${low}\&#176/${high}\&#176`;

    const conditionParagraph = document.createElement("span");
    conditionParagraph.classList.add("forecast-data");
    conditionParagraph.textContent = condition;

    paragraphContainer.appendChild(nameParagraph);
    paragraphContainer.appendChild(lowHighParagraph);
    paragraphContainer.appendChild(conditionParagraph);

    container.appendChild(icon);
    container.appendChild(paragraphContainer);

    return container;
  }

  function createUpcomingForecastElement(forecastObj) {
    const { condition, high, low } = forecastObj;

    const upcomingContainer = document.createElement("span");
    upcomingContainer.classList.add("upcoming");

    const symbol = document.createElement("span");
    symbol.classList.add("symbol");
    switch (condition) {
      case "Sunny":
        symbol.innerHTML = "&#x2600";
        break;
      case "Partly sunny":
        symbol.innerHTML = "&#x26C5";
        break;
      case "Overcast":
        symbol.innerHTML = "&#x2601";
        break;
      case "Rain":
        symbol.innerHTML = "&#x2614";
        break;
    }

    const forecastData = document.createElement("span");
    forecastData.classList.add("forecast-data");
    forecastData.innerHTML = `${low}\&#176/${high}\&#176`;

    const conditionData = document.createElement("span");
    conditionData.classList.add("forecast-data");
    conditionData.textContent = condition;

    upcomingContainer.appendChild(symbol);
    upcomingContainer.appendChild(forecastData);
    upcomingContainer.appendChild(conditionData);

    return upcomingContainer;
  }
}
attachEvents();