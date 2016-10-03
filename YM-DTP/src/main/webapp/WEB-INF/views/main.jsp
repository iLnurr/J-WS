<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>ufa</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <!-- Если вы используете API локально, то в URL ресурса необходимо указывать протокол в стандартном виде (http://...)-->
    <script src="http://api-maps.yandex.ru/2.1/?lang=ru_RU" type="text/javascript"></script>
    <script type="text/javascript">
        ymaps.ready(init);
        function init () {
            var myMap = new ymaps.Map('map', {
                center: [54.739,55.967],
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
            var actualProvider = trafficControl.getProvider('traffic#actual').state.set('infoLayerShown', true);





            function updateProvider () {
                trafficControl.getProvider('traffic#actual').update();
            }
            // Будем слать запрос на обновление данных каждые 4 минуты.
            window.setInterval(updateProvider, 4 * 60 * 1000);
        }
    </script>
    <style>
        html, body, #map {
            width: 100%; height: 100%; padding: 0; margin: 0;
        }
    </style>
</head>
<body>
<div id="map"></div>
</body>
</html>