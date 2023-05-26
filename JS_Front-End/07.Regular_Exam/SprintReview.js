function sprintReview(input){
    const elements = Number(input.shift());
    const taskTable = {};

    const commandParser = {
        Add: addTask,
        Change: changeStatus,
        Remove: removeTask,
    };

    for (let index = 0; index < elements; index++) {
        const [ assignee, taskId, title, status, points] = input.shift().split(':');
        if(taskTable.hasOwnProperty(assignee)){
            taskTable[assignee].push({ taskId, title, status, points});
        }else{
            taskTable[assignee] = [{ taskId, title, status, points}];
        }
    }

    while(input.length > 0){
        let commandLine = input.shift().split(':');
        const command = commandLine.shift().split(' ').shift();
        
        commandParser[command]([...commandLine]);
    }

    let todoPoints = 0;
    let inProgressPoints = 0;
    let codeReviewPoints = 0;
    let donePoints = 0;

    for (const key in taskTable) {
       const tasks = Object.values(taskTable[key]);
       for (const task of tasks) {
        switch(task.status){
            case "ToDo": 
            todoPoints += Number(task.points);
            break;
            case "In Progress": 
            inProgressPoints += Number(task.points);
            break;
            case "Code Review": 
            codeReviewPoints += Number(task.points);
            break;
            case "Done":
            donePoints += Number(task.points);
            break;
        }        
    }
}
console.log(`ToDo: ${todoPoints}pts`);
console.log(`In Progress: ${inProgressPoints}pts`);
console.log(`Code Review: ${codeReviewPoints}pts`);
console.log(`Done Points: ${donePoints}pts`);
if(donePoints >= (inProgressPoints + codeReviewPoints + todoPoints)){
    console.log('Sprint was successful!');
}else{
    console.log('Sprint was unsuccessful...');
}


    function addTask([assignee, taskId, title, status, points]){
        const newTask = {assignee,taskId,title,status,points};

        if(taskTable.hasOwnProperty(assignee)){
            taskTable[assignee].push(newTask);
        }else {
            console.log(`Assignee ${assignee} does not exist on the board!`)
        }
    }

    function changeStatus([assignee, taskId, newStatus]){
        if(taskTable.hasOwnProperty(assignee)){
            let searchingTask = taskTable[assignee].find((task) => task.taskId === taskId);
            if(searchingTask){
                searchingTask.status = newStatus;
            }else{
                console.log(`Task with ID ${taskId} does not exist for ${assignee}!`)
            }

        }else{
            console.log(`Assignee ${assignee} does not exist on the board!"`)
        }


    }

    function removeTask([assignee, index]){
        if(taskTable.hasOwnProperty(assignee)){
            const tasks = taskTable[assignee];
            if(index < 0 || index > tasks.length ){
                console.log('Index is out of range!');
            }else{
                tasks.splice(index,1);
            }
        }else{
            console.log(`Assignee ${assignee} does not exist on the board!`)
        }
    }

}

sprintReview( [
    '5',
    'Kiril:BOP-1209:Fix Minor Bug:ToDo:3',
    'Mariya:BOP-1210:Fix Major Bug:In Progress:3',
    'Peter:BOP-1211:POC:Code Review:5',
    'Georgi:BOP-1212:Investigation Task:Done:2',
    'Mariya:BOP-1213:New Account Page:In Progress:13',
    'Add New:Kiril:BOP-1217:Add Info Page:In Progress:5',
    'Change Status:Peter:BOP-1290:ToDo',
    'Remove Task:Mariya:1',
    'Remove Task:Joro:1',
]
)

// sprintReview(    [
//     '4',
//     'Kiril:BOP-1213:Fix Typo:Done:1',
//     'Peter:BOP-1214:New Products Page:In Progress:2',
//     'Mariya:BOP-1215:Setup Routing:ToDo:8',
//     'Georgi:BOP-1216:Add Business Card:Code Review:3',
//     'Add New:Sam:BOP-1237:Testing Home Page:Done:3',
//     'Change Status:Georgi:BOP-1216:Done',
//     'Change Status:Will:BOP-1212:In Progress',
//     'Remove Task:Georgi:3',
//     'Change Status:Mariya:BOP-1215:Done',
// ]

// )