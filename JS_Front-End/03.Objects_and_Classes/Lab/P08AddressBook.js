function addressBook(input){

    let addressBookData = {};

    for (const line of input) {
        let [ name, address] = line.split(':');

        addressBookData[name] = address;
    }

    let entries = Object.entries(addressBookData);

    entries
    .sort((nameA, nameB) => nameA[0].localeCompare(nameB[0]))
    .forEach(([key , value]) => console.log(`${key} -> ${value}`));

}

addressBook(['Bob:Huxley Rd',
'John:Milwaukee Crossing',
'Peter:Fordem Ave',
'Bob:Redwing Ave',
'George:Mesta Crossing',
'Ted:Gateway Way',
'Bill:Gateway Way',
'John:Grover Rd',
'Peter:Huxley Rd',
'Jeff:Gateway Way',
'Jeff:Huxley Rd']
)