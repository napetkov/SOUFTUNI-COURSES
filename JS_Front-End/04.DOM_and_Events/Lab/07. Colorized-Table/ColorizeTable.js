function colorize() {
    const fieldToColorized = Array.from(document.querySelectorAll('tr:nth-child(even)'));
    fieldToColorized.forEach((tr) =>{
        tr.style.backgroundColor = 'Teal';
    })

}