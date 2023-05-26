function convertToJason(firstName,lastName,hairColor){

    let person ={
        name:firstName,
        lastName:lastName,
        hairColor: hairColor 
    };

    console.log(JSON.stringify(person));

}

convertToJason('George', 'Jones', 'Brown');