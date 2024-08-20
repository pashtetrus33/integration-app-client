5.4 Декларативные методы для REST-сервисов
Введение
Из этого материала вы узнаете:

как реализовывать декларативные клиенты с помощью новых возможностей Spring Boot 3;
как создать HTTP-клиента, который сможет работать с базовыми типами HTTP-методов и их данными: GET, POST, PUT, DELETE.
HTTP-интерфейсы
Декларативный HTTP-интерфейс включает аннотированные методы для обмена данными по протоколу HTTP. Вы можете описать детали API, с которым хотите интегрироваться, с помощью специальных аннотаций в интерфейсе и позволить Spring сгенерировать прокси-объект, который реализует этот интерфейс. Такие интерфейсы позволяют уменьшить количество шаблонного кода.
