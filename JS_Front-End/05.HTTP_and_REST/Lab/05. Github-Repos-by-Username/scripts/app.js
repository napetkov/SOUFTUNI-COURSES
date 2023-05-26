function loadRepos() {
  const BASE_URL = "https://api.github.com/users/";
  const repos = document.getElementById("repos");
  const username = document.getElementById("username");

    repos.replaceChildren();
	
  

  fetch(`${BASE_URL}${username.value}/repos`, { method: "GET" })
    .then((res) => res.json())
    .then((data) => {
      data.forEach((repo) => {
        const li = document.createElement("li");
        const anchor = document.createElement("a");
        anchor.textContent = repo.full_name;
        anchor.href = repo.html_url;
		li.appendChild(anchor);
		repos.appendChild(li);
      });
    })
    .catch((err) => {
		console.error(err);
	});
}
