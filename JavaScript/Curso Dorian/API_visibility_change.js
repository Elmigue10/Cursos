const video = document.getElementById("video")

// addEventListener("visibilitychange",(evento) =>{
//     if(document.visibilityState==="visible"){
//         console.log("PLAY")
//         video.play()
//     }else if (document.visibilityState==="hide"){
//         console.log("PAUSE")
//         video.pause()
//     }
// })

addEventListener("visibilitychange",() => document.visibilityState ==="visible" ? video.play() : video.pause())