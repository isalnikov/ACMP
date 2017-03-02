/*
 *Написать J2EE приложение, которое принимает хмл вида

 

 <property name=”some name”>

 <property name=”some name”>

 <property name=”some name”>

 </property>

 <property name=”some name”>

 </property>

 <property name=”some name”>

 </property>

 <property name=”some name”>

 </property>

 </property>

 <property name=”some name”>

 </property>

 <property name=”some name”>

 </property>

 </property>

 <property name=”some name”>

 </property>

 <property name=”some name”>

 </property>

 <property name=”some name”>

 </property>

 <property name=”some name”>

 </property>

 

 Создает объектную модель полученного документа, и сохраняет его в базу, а также возвращает его пользователю.

 Объекты, хранящиеся в базе, повторяют древовидную структуру.

 Вложенность элементов не ограниченна.

 Хмл нужно загружать со странички в виде файла и отдавать его надо тоже в виде файла (upload/download)

 Странички можно сделать самыми простыми.

 

 Приложение должно собираться в war файл, с последующим деплоем на аппликейшин сервер (аппликейшин сервер можно использовать любой).

 

 База данных – любая (рекомендуется MySQL)

 

 Результаты тестового задания должны включать исходники приложения, инструкции по сборке и установке.
 */
package ru.isalnikov.yota;
