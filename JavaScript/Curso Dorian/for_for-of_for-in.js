let numeros=[1,2,3,4,5,6];
for (let i=0; i<=numeros.length; i++){
    console.log(numeros[i]);
}
let names= ["Miguel","Hugo","Luis","Julio"];
for(let name of names){
    console.log(name);
}
for(let index in names){
    console.log(index);
}
for(let name of names){
    if(name=="Hugo"){
        break
    }
    console.log(name);
}
for(let name of names){
    if(name=="Hugo"){
        continue
    }
    console.log(name);
}