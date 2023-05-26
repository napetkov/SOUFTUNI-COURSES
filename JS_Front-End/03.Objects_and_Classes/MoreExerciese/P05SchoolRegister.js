function schoolRegister(input){
    let students = [];
    
    
    let studentsRegister = input.reduce((data,currentStudent) => {
        let studentInfo = currentStudent.replaceAll(',','').split(' ');
        let grade = Number(studentInfo[4]);
        
        let studentName = studentInfo[2];
        let averageScore = Number(studentInfo[10]);
        if (averageScore < 3){
            return data;
        }
        
        let student = {
            studentName: studentName,
            averageScore: averageScore,
        }
        
        if(data.hasOwnProperty(grade)){
            students = data[grade];
        }else {
            students = [];
        }

        students.push(student);
        data[grade] = students;
        return data;
    },{});


Object.entries(studentsRegister)
            .sort((gradeA,gradeB) => gradeA[0]-gradeB[0])
            .forEach((grade) =>{
                 console.log(`${Number(grade[0])+1} Grade`);
                 let studentsList = grade[1].reduce((data,currentValue) =>{
                    // let student = Object.entries(currentValue);
                    data.push(currentValue.studentName);
                    return data;
                 },[]);

                 let averageScore = grade[1].reduce((data,currentValue) =>{
                    // let student = Object.entries(currentValue);
                    data +=currentValue.averageScore;
                    return data;
                 },0);  
                 averageScore = averageScore / grade[1].length; 

                 console.log(`List of students: ${studentsList.join(' ')}`);
                 console.log(`Average annual score from last year: ${averageScore.toFixed(2)}\n`);
                 
            });
}

schoolRegister([
'Student name: George, Grade: 5, Graduated with an average score: 2.75',
'Student name: Alex, Grade: 9, Graduated with an average score: 3.66',
'Student name: Peter, Grade: 8, Graduated with an average score: 2.83',
'Student name: Boby, Grade: 5, Graduated with an average score: 4.20',
'Student name: John, Grade: 9, Graduated with an average score: 2.90',
'Student name: Steven, Grade: 2, Graduated with an average score: 4.90',
'Student name: Darsy, Grade: 1, Graduated with an average score: 5.15'
]

    )