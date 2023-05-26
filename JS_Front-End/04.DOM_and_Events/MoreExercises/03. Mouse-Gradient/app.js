function attachGradientEvents() {
    let element = document.getElementById('gradient');
    let result = document.getElementById('result')
    element.addEventListener('mousemove', hoverHandler);
    element.addEventListener('mouseleave', mouseOutHandler);

    function hoverHandler (event){
        const elementRect = event.target.clientWidth;
        const distanceX =  event.offsetX;
        const distancePrecent = Math.floor(distanceX / elementRect* 100);
        result.textContent = `${distancePrecent}%`
    }

    function mouseOutHandler(){
        result.textContent = '';
    }
}