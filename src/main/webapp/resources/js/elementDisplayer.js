function LevelSelectorController() {
    let lvlCheck = document.querySelector('#lvl-condition');
    let lvlFourCheck = lvlCheck.options[lvlCheck.selectedIndex].value;
    let showLvlFour = document.querySelector('#lvl-4');

    if (lvlFourCheck >= 4) {
        showLvlFour.style.display = 'block';
    } else if (lvlFourCheck < 4){
        showLvlFour.style.display = 'none';
    }
    console.log(lvlFourCheck);
}

document.querySelector('#featsBox').onclick = function FeatSelected(){
    if(this.checked){
        document.querySelector('#lvl-4-feat').style.display = 'block'
    } else {
        document.querySelector('#lvl-4-feat').style.display = 'none'
    }
}

document.querySelector('#scoreBox').onclick = function ScoreSelected(){
    if(this.checked){
        document.querySelector('#lvl-4-increase').style.display = 'block'
    } else {
        document.querySelector('#lvl-4-increase').style.display = 'none'
    }
}