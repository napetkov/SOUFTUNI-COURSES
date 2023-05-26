async function loadCommits() {
    const BASE_URL = 'https://api.github.com/repos/'
   const username = document.getElementById('username');
   const repo = document.getElementById('repo');
   const commits = document.getElementById('commits');

   
   const allCommitsRes = await fetch(`${BASE_URL}${username.value}/${repo.value}/commits`, {method: 'GET'})
   const data = await allCommitsRes.json();
   try{
        data.forEach((commitRes) =>{
            const li = document.createElement('li');
            li.textContent = `${commitRes.commit.author.name}: ${commitRes.commit.message}`;
            commits.appendChild(li)});
        }catch(error){
    const li = doc.createElement('li');
    const errorMessage = error.status;
    li.textContent = `Error: ${errorMessage} (Not found)`
    commits.appendChild(li);    
   };
}