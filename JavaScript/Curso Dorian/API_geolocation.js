const button = document.getElementById('button')
button.addEventListener('click', () => {
    const geolocation = navigator.geolocation
    geolocation.getCurrentPosition(getPosition, error, options)
})
const options = {
    enableHightAccuracy: true,
    timeout: 5000,
    maximunAge: 0
}

function getPosition (position) {
    console.log(position)
}

function error (error) {
    console.log(error);
}