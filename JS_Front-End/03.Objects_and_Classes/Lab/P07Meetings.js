function meetings([...input]){

    let meetingSchedule = {};



      for (let i = 0; i < input.length; i++) {
        
        let[ day, name ] = input[i].split(' ');
    
            if(Object.keys(meetingSchedule).includes(day)){
            console.log(`Conflict on ${day}!`);
        }else{
            meetingSchedule[day] = name;
            console.log(`Scheduled for ${day}`);
        }
    }

Object.entries(meetingSchedule).forEach(([day, name]) => console.log(`${day} -> ${name}`));

}

meetings(['ab ba','cb bc', 'cd dc','ab bb']);