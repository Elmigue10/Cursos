const person ={
    name:"Miguel",
    age:19,
    sports:["Futbol", "Voleibol", "Baloncesto", "Ping pong"]
};
console.log(person.name);
console.log(person["name"]);
for (const key in person){
    console.log(key);
    console.log(person[key]);
}
for(const sport of person.sports){
    console.log(sport)
}
console.log(`Hola ${person.name}. Tienes ${person.age} y tus deportes son ${person.sports.join(",")}`);