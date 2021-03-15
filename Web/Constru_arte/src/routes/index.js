const { Router } = require('express');
const router = Router();

const nodemailer = require('nodemailer');

router.post('/send-email', async (req, res) => {
    const { name, apellidos, email, telefono, direccion, mensaje } = req.body;

    contentHTML = `
        <h1>User Information</h1>
        <ul>
            <li>Nombres: ${name}</li>
            <li>Apellidos: ${apellidos}</li>
            <li>Correo electronico: ${email}</li>
            <li>Telefono: ${telefono}</li>
            <li>Direccion: ${direccion}</li>
        </ul>
        <p>${mensaje}</p>
    `;

    let transporter = nodemailer.createTransport({
        service:"gmail",
        auth:{
            user:"miguelvalbuena.pruebas@gmail.com",
            pass:"miguelpruebas"
        }
    });

    let info = await transporter.sendMail({
        from:"miguelvalbuena.pruebas@gmail.com",
        to:"miguelvalbuena.pruebas@gmail.com",
        subject:`Idea de proyecto ${name} ${apellidos}`,
        // text: 'Hello World'
        html: contentHTML
    })

    console.log('Message sent: %s', info.messageId);
    // Message sent: <b658f8ca-6296-ccf4-8306-87d57a0b4321@example.com>

    // Preview only available when sending through an Ethereal account
    console.log('Preview URL: %s', nodemailer.getTestMessageUrl(info));
    // Preview URL: https://ethereal.email/message/WaQKMgKddxQDoou...

    res.redirect('/Success.html');
});

module.exports = router;