function moviesParser(input) {
  let movies = [];

    for (const line of input) {
        
        let commandToken = line.split(' ');

        if(commandToken.includes('addMovie')){
            let movieName = commandToken.slice(1).join(' ');
            addMovie(movieName);
        }else if(commandToken.includes('directedBy')){
            const commandIndex = commandToken.indexOf('directedBy');
            let movieName = commandToken.slice(0, commandIndex).join(' ');
            let movieDirector = commandToken.slice(commandIndex + 1).join(' ');

            addDirector(movieName,movieDirector);

        }else if(commandToken.includes('onDate')){
            const commandIndex = commandToken.indexOf('onDate');
            let movieName = commandToken.slice(0, commandIndex).join(' ');
            let movieDate = commandToken.slice(commandIndex + 1).join(' ');
            
            addDate(movieName,movieDate);
        }
    }


    for (const movie of movies) {
        if(movie.hasOwnProperty('name') && movie.hasOwnProperty('director') && movie.hasOwnProperty('date')){
            console.log(JSON.stringify(movie));
        }
    }
 
    // console.log(movies.forEach((m) => {
    //     if(m.hasOwnProperty('name') && m.hasOwnProperty('director') && m.hasOwnProperty('date')){
    //         console.log(JSON.stringify(m));
    //     }
    // }));


  function addMovie(name) {
    movies.push({ name });
  }

  function addDirector(name, director) {
    let movie = movies.find((m) => m.name === name);

    if (movie) {
      movie.director = director;
    }
  }
    function addDate(name, date) {
      let movie = movies.find((m) => m.name === name);

      if (movie) {
        movie.date = date;
      }
   
  }

}

moviesParser([
    'addMovie Fast and Furious',
    'addMovie Godfather',
    'Inception directedBy Christopher Nolan',
    'Godfather directedBy Francis Ford Coppola',
    'Godfather onDate 29.07.2018',
    'Fast and Furious onDate 30.07.2018',
    'Batman onDate 01.08.2018',
    'Fast and Furious directedBy Rob Cohen'
    ]
    );
