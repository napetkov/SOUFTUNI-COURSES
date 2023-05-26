function solve() {
  const BASE_URL = "http://localhost:3030/jsonstore/bus/schedule/";
  let busStopId = "depot";
  const departBtn = document.getElementById("depart");
  const arriveBtn = document.getElementById("arrive");
  const infoBox = document.querySelector(".info.info");

  function depart() {
    fetch(`${BASE_URL}${busStopId}`, { method: "GET" })
      .then((res) => res.json())
      .then((data) => {
        infoBox.textContent = `Next stop ${data.name}`;
        departBtn.disabled = true;
        arriveBtn.disabled = false;
        // busStopId = `${data.next}`;
      })
      .catch(() => {
        infoBox.textContent = "Error";
        departBtn.disabled = true;
        arriveBtn.disabled = true;
      });
  }

  function arrive() {
    fetch(`${BASE_URL}${busStopId}`, { method: "GET" })
      .then((res) => res.json())
      .then((data) => {
        infoBox.textContent = `Arriving at ${data.name}`;
        departBtn.disabled = false;
        arriveBtn.disabled = true;
        busStopId = data.next;
      })
      .catch(() => {
        infoBox.textContent = "Error";
        departBtn.disabled = 'true';
        arriveBtn.disabled = 'true';
      });
  }

  return {
    depart,
    arrive,
  };
}

let result = solve();
