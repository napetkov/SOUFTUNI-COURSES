function solve() {
  const textArea = document.getElementsByTagName("textarea")[0];
  const text = textArea.value;
  const sentences = text.split(".");
  sentences.pop();
  
 
  const output = document.getElementById("output");

  while (sentences.length > 0) {
    let paragraphSentences = sentences.splice(0, 3)
          .map((p) => p.trimStart());
         
    let paragraph = paragraphSentences.join(".") + '.';

    const p = document.createElement("p");
    p.textContent = paragraph;
    output.appendChild(p);
  }
}
