function employeesParser(input){
    let employees = {};

    employees = input.reduce((data,personName) => {
        data[personName] = personName.length;
        return data;
    },{} )

   Object.entries(employees).forEach(([personalName,personalNumber]) =>
   console.log(`Name: ${personalName} -- Personal Number: ${personalNumber}`))

}

employeesParser([
    'Silas Butler',
    'Adnaan Buckley',
    'Juan Peterson',
    'Brendan Villarreal'
    ]
    )