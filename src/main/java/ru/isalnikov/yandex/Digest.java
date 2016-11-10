// Double-checked locking (можно гуглить по этому термину) и связанные с ним эффекты (digest в разных потоках может читаться по-разному)
//Излишняя contention без нужды. Все вставки (на _разных_) ключах блокируют друг друга на время вычисления digest.
//Про разные массивы с одинаковыми значениями уже сказали.
//a = {1}; b = d.digest(a); a[0] = 2; c = d.digest(a). Что явно дает не то, что хотелось.
//a = {1}; b = d.digest(a); b[1] = 4; c = d.digest(a). Тоже что-то не то ;)
//Не понятно, почему абстрактный класс а не композиция. Почему дигест всегда должен кэшироваться? Разве нельзя отдельно вычислялку сделать?
//Недостаточный уровень абстракции. Зачем конкретные типы, можно сделать generic memo.
//Непонятные намерения по расширению. Почему digest public nonfinal и при этом есть abstract doDigest. Если я переопределю digest, зачем мне "ненужные" методы в наследнике?
//Учитывая все вышесказанное (достаточно первых двух пунктов), проблема в авторе кода и дешевых понтах. Автор не разбирается в многпоточности (и еще много чем) но пытается писать "крутой" код. Банальная синхронизация на каждом доступе была бы не сильно хуже (и работала бы корректно). /**
// * 
// */
package ru.isalnikov.yandex;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Igor Salnikov <admin@isalnikov.com>
 */


public abstract class Digest {
      private Map<byte[], byte[]> cache = new HashMap<>();
      public byte[] digest(byte[] input) {
          byte[] result = cache.get(input);
          if (result == null) {
              synchronized (cache) {
                  result = cache.get(input);
                  if (result == null) {
                      result = doDigest(input);
                      cache.put(input, result);
                  }
              }
          }
          return result;
      }
      protected abstract byte[] doDigest(byte[] input);
  }


//public abstract class Digest {
//      private Map<byte[], byte[]> cache = new ConcurrentHashMap<byte[], byte[]>();
//      public byte[] digest(byte[] input) {
//          return cache.computeIfAbsent(input, k -> doDigest(k));
//      }
//      protected abstract byte[] doDigest(byte[] input);
//  }