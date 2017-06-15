package ru.isalnikov.tobox;

/**
 *
 *
 * Тестовое задание: 1. Пусть N такое число, что 0xff = 0xc0 + N. Напишите
 * представление числа N в десятичной системе счисления.	 *
 *
 * 2. Какие из следующих стандартных контейнеров позволяют найти в них элемент
 * по его значению за O(log(n))? java.util.Vector<E>
 * java.util.ArrayList<E>
 * java.util.LinkedList<E>
 * java.util.TreeSet<E>
 * java.util.HashSet<E>
 * сортированный java.util.Vector<E>
 * сортированный java.util.ArrayList<E>
 * сортированный java.util.LinkedList<E>
 *
3. Перечислите все проблемы, которые вы видите в данном коде: public abstract
 * class Digest { private Map<byte[], byte[]> cache = new
 * HashMap<byte[], byte[]>();
 *
 * public byte[] digest(byte[] input) { byte[] result = cache.get(input); if
 * (result == null) { synchronized (cache) { result = cache.get(input); if
 * (result == null) { result = doDigest(input); cache.put(input, result); } } }
 * return result; }
 *
 * protected abstract byte[] doDigest(byte[] input); } 4. Опишите процесс
 * установки TCP соединения  *
 * 5. Перечислите типы HTTP-ответов и их назначение
 *
 * 6. Напишите shell скрипт для подсчета ответов сервера, содержащих Internal
 * Server Error (HTTP code: 500) за неделю. Логи расположены в директории
 * /var/log/nginx. Логи имеют дневную ротацию: access.log.yyyy.mm.dd Структура
 * лога представлена ниже. 193.34.164.206 - - [15/Dec/2016:08:49:04 +0000] "GET
 * /foo HTTP/1.1" 200 16064 "http://tobox.com/" "Mozilla/5.0 (Windows NT 6.1;
 * WOW64; rv:50.0) Gecko/20100101 Firefox/50.0" 193.34.164.206 - -
 * [15/Dec/2016:08:49:04 +0000] "GET /bar HTTP/1.1" 500 16064
 * "http://tobox.com/" "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:50.0)
 * Gecko/20100101 Firefox/50.0" 193.34.164.206 - - [15/Dec/2016:08:49:04 +0000]
 * "GET /baz HTTP/1.1" 200 16064 "http://tobox.com/" "Mozilla/5.0 (Windows NT
 * 6.1; WOW64; rv:50.0) Gecko/20100101 Firefox/50.0"
 *
 */
