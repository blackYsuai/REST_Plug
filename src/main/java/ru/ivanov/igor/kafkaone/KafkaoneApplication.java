package ru.ivanov.igor.kafkaone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
Задание №2
Разработать заглушку на Java (Spring), которая обеспечивает обработку http-запросов и запись сообщений в Kafka.
1.Заглушка должна обрабатывать запросы с маршрутом /post-message и методом запроса POST;
2.Тело запроса должно содержать json, в котором присутствует всего одно поле msg_id. Пример запроса к заглушке: { "msg_id": "1234567890" }
3.Получив запрос POST /post-message, заглушка должна достать из тела запроса msg_id и на его основе сформировать сообщение, которое затем отправится в кафку в топик «postedmessages»;
4.В сообщении в кафку – текущее время (сохранить unix timestamp в момент получения запроса), маршрут запроса, метод запроса и msg_id.
Пример сообщения в топик Kafka:{ "msg_id": "1234567890", "timestamp": "1694171306000", "method": "POST", "uri": "/post-message" }
5.В ответ на запрос заглушка возвращает «200 ОК» если записала; если в процессе работы возникла ошибка и сообщение не дошло до кафки – возвращаем ошибку 500;
Для выполнения задания понадобится вручную поднять локально Kafka и Zookeeper. Инструкции в интернете в помощь.
Чтобы просмотреть очередь сообщений в кафке, можно воспользоваться Kafka Tool.
*/


@SpringBootApplication
public class KafkaoneApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaoneApplication.class, args);
	}

}
