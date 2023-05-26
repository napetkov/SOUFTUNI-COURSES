function getInfo() {
  const BASE_URL = "http://localhost:3030/jsonstore/bus/businfo/";
  const busStop = document.getElementById("stopId");
  const stopName = document.getElementById("stopName");
  const busList = document.getElementById("buses");

  busList.replaceChildren();

  stopName.textContent = "";

  fetch(`${BASE_URL}${busStop.value}`, { method: "GET" })
    .then((resp) => resp.json())
    .then((data) => {
      stopName.textContent = data.name;
      let busLines = Object.entries(data.buses);
 
      busLines.forEach(([key, value]) => {
        const li = document.createElement("li");
        li.textContent = `Bus ${key} arrives in ${value} minutes`;
        busList.appendChild(li);
      });
    })
    .catch(() => {
      stopName.textContent = "Error";
    });
}
