function songs([...input]) {
  let numbersOfSongs = input[0];
  let typeList = input[input.length - 1];

  let playList = {};

  for (let i = 1; i < input.length - 1; i++) {
    let [typeList, name, time] = input[i].split("_");
    playList[name] = typeList;
  }
  let playListEntries = Object.entries(playList);

  if (typeList === "all") {
    playListEntries.forEach(([key, value]) => console.log(key));
  } else {
    playListEntries
      .filter(([key, value]) => value === typeList)
      .forEach(([key, value]) => console.log(key));
  }
}

songs([2,
    'like_Replay_3:15',
    'ban_Photoshop_3:48',
    'all']
    );
