const text = document.getElementById("text").textContent;
const regEx = /lorem/gi
const regEx = ("lorem","gi")
const regEx = ("/lorem/","gi")

console.log(regEx.test(text));
console.log(text.includes("Lorem"))