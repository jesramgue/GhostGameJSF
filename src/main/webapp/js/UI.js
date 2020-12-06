function limitText(limitField, limitNum) {
    if (limitField.value.length > limitNum) {
        limitField.value = limitField.value.substring(0, limitNum);
    }
}

function changeUI() {
    if (document.getElementById('char').style.display == '') {
        document.getElementById('char').style.display = 'none';
        document.getElementById('char').value = '';
    } else {
        document.getElementById('char').style.display = '';
        document.getElementById('char').value = '';
    }
}
function resetUI() {
    document.getElementById('char').style.display = '';
    document.getElementById('char').value = '';
}