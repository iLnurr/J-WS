ymaps.ready(init);

function init () {
    var myMap = new ymaps.Map('map', {
        center: [56.136, 40.390],
        zoom: 10,
        controls: []
    });

    // var actualProvider = new ymaps.traffic.provider.Actual({}, {infoLayerShown: true});
    // actualProvider.setMap(myMap);
// // Запретим показ балунов по клику для слоев пробок и инфоточек.
//     myMap.layers.options.set({
//         // Название опции сформировано из опции хотспотного слоя
//         // 'openBalloonOnClick' путем добавления префикса 'trafficJam'.
//         trafficJamOpenBalloonOnClick: false,
//         // Аналогично формируется название опции для слоя инфоточек.
//         trafficInfoOpenBalloonOnClick: false
//     });

    // Создадим элемент управления "Пробки".
    var trafficControl = new ymaps.control.TrafficControl({ state: {
        // Отображаются пробки "Сейчас".
        providerKey: 'traffic#actual',
        // Начинаем сразу показывать пробки на карте.
        trafficShown: true
    }});
    // Добавим контрол на карту.
    myMap.controls.add(trafficControl);
    // Получим ссылку на провайдер пробок "Сейчас" и включим показ инфоточек.
    trafficControl.getProvider('traffic#actual').state.set('infoLayerShown', true);
}