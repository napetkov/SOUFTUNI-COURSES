function extract(content) {
    let element = document.getElementById(content);
    let text = element.textContent;
    const regex = /\(([^)]+)\)/g;
    let matchedText = regex.exec(text);
    let matches = [];

    while(matchedText !== null){
        matches.push(matchedText[1]);
        matchedText = regex.exec(text);
    }

    return matches.join('; ');
}