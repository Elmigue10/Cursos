function saludar(){
    console.log("Hola");
}
saludar();

const saludo = () => console.log("Hola");

const saludarusuario = (user) => console.log(`Hola ${user}`);
saludarusuario("Miguel");

const suma = (num1,num2)=>{
    if (num1==2){
        return num1+num2;
    }
    return num1
}
console.log(suma(2,3));
console.log(suma(4,3));
