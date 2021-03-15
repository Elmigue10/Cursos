let template = require("email-templates").EmailTemplate
let async = require("async")
let nodemailer = require("nodemailer")

const enviar= (para, asunto, plantilla, datos) => (
    async.waterfall([
        function(next){
            let motor = new template(plantilla)
            motor.render(datos, function(err, resultado){
                next(resultado.html)
            })

        }
    ], function(html){
        let conexion = nodemailer.createTransport({
            service:"gmail",
            auth:{
                user:"miguelvalbuena.pruebas@gmail.com",
                pass:"miguelpruebas"
            }
        })

        let email = {
            from:"miguel",
            to: para,
            subject:asunto,
            html:html
        }

        conexion.sendMail(email)
    })
)